
package by.mark.primitivevswrapper.ints.example1;

import static by.mark.primitivevswrapper.MemoryUtils.ONE_GB;

public class IntArrayExample1 {

    public static void main(String[] args) {
        int[] ints = new int[ONE_GB / 4];

        System.out.println(ints.length);
    }
}
