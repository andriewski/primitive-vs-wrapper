package by.mark.primitivevswrapper.ints.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.getRealSizeOfList;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;

public class IntsListAddingExample3 {

    private static final int EXPECTED_ELEMENTS_TO_ADD = MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB / 2;

    public static void main(String[] args) {
        printBaseInfo();

        List<Integer> ints = new ArrayList<>(EXPECTED_ELEMENTS_TO_ADD);

        IntStream.range(0, EXPECTED_ELEMENTS_TO_ADD)
                .forEach(ints::add);

        printUsefulAllocatedMemoryByInts(getRealSizeOfList(ints));
    }
}
