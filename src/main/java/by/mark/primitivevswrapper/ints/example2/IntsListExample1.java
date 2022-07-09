package by.mark.primitivevswrapper.ints.example2;

import java.util.ArrayList;
import java.util.List;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.getRealSizeOfList;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;

public class IntsListExample1 {

    public static void main(String[] args) {
        printBaseInfo();

        List<Integer> ints = new ArrayList<>(MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB);

        printUsefulAllocatedMemoryByInts(getRealSizeOfList(ints));
    }
}
