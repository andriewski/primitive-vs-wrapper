package by.mark.primitivevswrapper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Runtime.getRuntime;
import static java.lang.String.format;
import static java.lang.System.lineSeparator;

public abstract class MemoryUtils {

    public static final int ONE_MB = 1024 * 1024;
    public static final int ONE_GB = ONE_MB * 1024;

    public static final double JAVA_INNER_KITCHEN_STUFF_ALLOCATION_MEMORY = 0.002;
    public static final double FREE_MEMORY_TO_ALLOCATE_PART = 1 - JAVA_INNER_KITCHEN_STUFF_ALLOCATION_MEMORY;

    public static final int MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB = (int) (ONE_GB * FREE_MEMORY_TO_ALLOCATE_PART);
    public static final int MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB = MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB / 4;
    private static final AtomicInteger COUNTER = new AtomicInteger();

    public static void printBaseInfo() {
        System.out.println("To allocate: ~" + MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB / ONE_MB + " MB" + lineSeparator());
        int javaConsumesThatAmountOfBytes = ONE_GB - (int) (ONE_GB * FREE_MEMORY_TO_ALLOCATE_PART);
        System.out.println("Java inner kitchen consumes: ~" + javaConsumesThatAmountOfBytes / ONE_MB + " MB" + lineSeparator());
        printJavaBitVersion();
    }

    public static void printUsefulAllocatedMemoryByBytes(int bytes) {
        System.out.println("Useful allocate memory by bytes: ~" + bytes / ONE_MB + " MB" + lineSeparator());
    }

    public static void printUsefulAllocatedMemoryByInts(int ints) {
        System.out.println("Useful allocate memory by ints: ~" + ints * 4 / ONE_MB + " MB" + lineSeparator());
    }

    public static void incrementIteration() {
        COUNTER.incrementAndGet();
    }

    public static int getRealSizeOfList(List<?> list) {
        try {
            Field elementDataField = ArrayList.class.getDeclaredField("elementData");
            elementDataField.setAccessible(true);

            return ((Object[]) elementDataField.get(list)).length;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void addHookBeforeJavaDied(int expected) {
        getRuntime()
                .addShutdownHook(new Thread(() -> System.out.println(outputString(expected, COUNTER.get()))));
    }

    private static String outputString(int expected, int actual) {
        return format("Expected %d, real %d, percentage %,.2f", expected, actual, (1.0 * actual / expected) * 100) + "%";
    }

    /**
     * When writing Java code, how do I distinguish between 32 and 64-bit operation?
     * There's no public API that allows you to distinguish between 32 and 64-bit operation.
     * Think of 64-bit as just another platform in the write once, run anywhere tradition.
     * However, if you'd like to write code which is platform specific (shame on you),
     * the system property sun.arch.data.model has the value "32", "64", or "unknown".
     * <p>
     * <a href="https://www.oracle.com/java/technologies/hotspotfaq.html#64bit_detection">from</a>
     */
    private static void printJavaBitVersion() {
        System.out.println("Current java bit version is " + System.getProperty("sun.arch.data.model"));
    }
}
