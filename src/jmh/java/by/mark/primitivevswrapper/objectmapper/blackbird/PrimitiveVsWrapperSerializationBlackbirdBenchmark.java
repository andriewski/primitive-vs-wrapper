package by.mark.primitivevswrapper.objectmapper.blackbird;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.LOTS_OF_PRIMITIVES_EXCEEDED_BYTE_CACHE;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.LOTS_OF_PRIMITIVES_WITHIN_BYTE_CACHE;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.LOTS_OF_WRAPPERS_EXCEEDED_BYTE_CACHE;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.LOTS_OF_WRAPPERS_WITHIN_BYTE_CACHE;
import static by.mark.primitivevswrapper.objectmapper.blackbird.BlackbirdBenchmarkUtils.writeValue;

@SuppressWarnings("unused")
public class PrimitiveVsWrapperSerializationBlackbirdBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String ___serializeObjectWithALotOfWrappersWithinByteCache___() {
        return writeValue(LOTS_OF_WRAPPERS_WITHIN_BYTE_CACHE);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String ___serializeObjectWithALotOfWrappersExceededByteCache___() {
        return writeValue(LOTS_OF_WRAPPERS_EXCEEDED_BYTE_CACHE);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String ___serializeObjectWithALotOfPrimitivesWithinByteCache___() {
        return writeValue(LOTS_OF_PRIMITIVES_WITHIN_BYTE_CACHE);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public String ___serializeObjectWithALotOfPrimitivesExceededByteCache___() {
        return writeValue(LOTS_OF_PRIMITIVES_EXCEEDED_BYTE_CACHE);
    }
}
