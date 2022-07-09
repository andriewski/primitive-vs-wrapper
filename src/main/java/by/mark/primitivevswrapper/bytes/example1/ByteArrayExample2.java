package by.mark.primitivevswrapper.bytes.example1;

import static by.mark.primitivevswrapper.MemoryUtils.MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB;
import static by.mark.primitivevswrapper.MemoryUtils.printBaseInfo;
import static by.mark.primitivevswrapper.MemoryUtils.printUsefulAllocatedMemoryByBytes;

public class ByteArrayExample2 {

    public static void main(String[] args) {
        printBaseInfo();

        byte[] bytes = new byte[MAX_POSSIBLE_MEMORY_TO_ALLOCATE_FROM_1_GB];

        printUsefulAllocatedMemoryByBytes(bytes.length);
    }
}
