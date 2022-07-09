package by.mark.primitivevswrapper.ints.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.getRealSizeOfList;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;

public class IntsListAddingExample2 {

    public static void main(String[] args) {
        printBaseInfo();

        List<Integer> ints = new ArrayList<>(MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB);

        IntStream.range(0, MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB)
                .forEach(ints::add);

        printUsefulAllocatedMemoryByInts(getRealSizeOfList(ints));
    }
}
