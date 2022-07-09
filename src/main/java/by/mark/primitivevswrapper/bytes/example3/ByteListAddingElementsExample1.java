package by.mark.primitivevswrapper.bytes.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByBytes;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;

public class ByteListAddingElementsExample1 {

    /**
     * Prerequisites:
     * Minimum object size is 16 bytes for modern 64-bit JDK since the object has 12-byte header,
     * padded to a multiple of 8 bytes.
     * In 32-bit JDK, the overhead is 8 bytes, padded to a multiple of 4 bytes.
     * <a href="https://www.baeldung.com/java-size-of-object#1-objects-references-and-wrapper-classes">from</a>     
     */
    public static void main(String[] args) {
        printBaseInfo();

        int maxElements = MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB / 4;

        List<Byte> bytes = new ArrayList<>(maxElements);

        IntStream.range(0, maxElements)
                .forEach(i -> bytes.add((byte) i));

        printUsefulAllocatedMemoryByBytes(bytes.size());
    }
}
