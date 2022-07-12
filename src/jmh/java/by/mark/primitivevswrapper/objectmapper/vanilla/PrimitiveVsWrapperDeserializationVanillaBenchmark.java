package by.mark.primitivevswrapper.objectmapper.vanilla;

import by.mark.primitivevswrapper.objectmapper.LotsOPrimitives;
import by.mark.primitivevswrapper.objectmapper.LotsOfWrappers;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_EXCEEDED_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_WITHIN_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.vanilla.VanillaBenchmarkUtils.readValue;

@SuppressWarnings("unused")
public class PrimitiveVsWrapperDeserializationVanillaBenchmark {

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
