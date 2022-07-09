package by.mark.primitivevswrapper.ints.example3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB;
import static by.mark.primitivevswrapper.MemoryUtils.addHookBeforeJavaDied;
import static by.mark.primitivevswrapper.MemoryUtils.getRealSizeOfList;
import static by.mark.primitivevswrapper.MemoryUtils.incrementIteration;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByInts;

@SuppressWarnings("DuplicatedCode")
public class IntsListAddingExample4 {

    private static final int ELEMENTS = MAX_POSSIBLE_INTS_ELEMENTS_TO_ALLOCATE_FOR_1GB / 4;

    public static void main(String[] args) {
        printBaseInfo();

        addHookBeforeJavaDied(ELEMENTS);

        List<Integer> ints = new ArrayList<>(ELEMENTS);

        IntStream.range(0, ELEMENTS)
                .forEach(i -> {
                    ints.add(i);
                    incrementIteration();
                });

        printUsefulAllocatedMemoryByInts(getRealSizeOfList(ints));
    }
}
