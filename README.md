Repo show in examples how primitive and wrapper types (byte and int) in Java work.

Pre-conclusion:

1. Nobody really uses it, but still - allocation for List<Bytes> costs x4 of memory.
   1 byte costs 1 byte :). Byte costs 4 bytes due to Byte.ByteCache - in lists only references to cached values are stored.
2. Allocation for List<Integer> costs x5 of memory.
   int costs 4 bytes. Integer in List costs 16 bytes + 4 bytes for reference.

Conclusion:

1. Try to avoid wrapper classes they cost more and works slower.
2. The only reason why you can use in you program - for some values that are not defined by user,
   but even in such situation initial value of primitive int = 0 may be interpreted as a not defined value.
3. For some cases when you need to work with a lot of primitive data,
   before JEP 401 and 402 are published (https://openjdk.org/jeps/401 and https://openjdk.org/jeps/402)
   you'd better use private static inner class to create handy wrapper over int array
   just to make code readable and less memory consuming.

Also check links

1. About performance for primitive vs wrapper types. https://www.baeldung.com/java-primitives-vs-objects#3-performance
2. About new upcoming features in project
   Valhalla. https://blogs.oracle.com/javamagazine/post/java-jdk-18-evolution-valhalla-panama-loom-amber
