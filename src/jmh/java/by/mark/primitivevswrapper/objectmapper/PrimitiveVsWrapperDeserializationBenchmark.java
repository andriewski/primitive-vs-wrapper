package by.mark.primitivevswrapper.objectmapper;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static by.mark.primitivevswrapper.objectmapper.BenchmarkUtils.VALUES_EXCEEDED_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.BenchmarkUtils.VALUES_WITHIN_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.BenchmarkUtils.readValue;

@SuppressWarnings("unused")
public class PrimitiveVsWrapperDeserializationBenchmark {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappers ___deserializeObjectWithALotOfWrappersWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappers.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappers ___deserializeObjectWithALotOfWrappersExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappers.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitives ___deserializeObjectWithALotOfPrimitivesWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitives.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitives ___deserializeObjectWithALotOfPrimitivesExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitives.class);
    }
}
