
package by.mark.primitivevswrapper.bytes.example1;

import static by.mark.primitivevswrapper.MemoryUtils.ONE_GB;

public class ByteArrayExample1 {

    public static void main(String[] args) {
        byte[] bytes = new byte[ONE_GB];

        System.out.println(bytes.length);
    }
}
