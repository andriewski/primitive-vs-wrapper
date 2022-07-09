package by.mark.primitivevswrapper.ints.example1;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;

public class IntArrayExample2 {

    public static void main(String[] args) {
        printBaseInfo();

        int[] ints = new int[MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB];

        printUsefulAllocatedMemoryByInts(ints.length);
    }
}
