package by.mark.primitivevswrapper.bytes.example2;

import java.util.ArrayList;
import java.util.List;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB;
import static by.mark.primitivevswrapper.MemoryUtils.getRealSizeOfList;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByBytes;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;

public class ByteListExample5 {

    public static void main(String[] args) {
        printBaseInfo();

        List<Byte> bytes = new ArrayList<>(MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB / 4);

        printUsefulAllocatedMemoryByBytes(getRealSizeOfList(bytes));
    }
}
