package by.mark.primitivevswrapper.ints.example4;

import java.util.stream.IntStream;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.addHookBeforeJavaDied;
import static by.mark.primitivevswrapper.MemoryUtils.incrementIteration;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;

public class CustomIntsListAddingExample {

    private static final int EXPECTED_ELEMENTS_TO_ADD = MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;

    public static void main(String[] args) {
        printBaseInfo();

        addHookBeforeJavaDied(EXPECTED_ELEMENTS_TO_ADD);

        NotPublicInnerIntList ints = new NotPublicInnerIntList(EXPECTED_ELEMENTS_TO_ADD);

        IntStream.range(0, EXPECTED_ELEMENTS_TO_ADD)
                .forEach(i -> {
                    ints.add(i);
                    incrementIteration();
                });

        printUsefulAllocatedMemoryByInts(ints.size);
    }

    private static class NotPublicInnerIntList {

        int[] ints;
        int size = 0;

        NotPublicInnerIntList(int capacity) {
            this.ints = new int[capacity];
        }

        void add(int i) {
            if (size == ints.length) {
                grow();
            }

            int position = size++;
            ints[position] = i;
        }

        // This is just an example. It won't be used
        private void grow() {
            int[] newInts = new int[(int) (ints.length * 1.5)];
            System.arraycopy(ints, 0, newInts, 0, ints.length);
            ints = newInts;
        }
    }
}
