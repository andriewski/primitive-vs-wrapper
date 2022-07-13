package by.mark.primitivevswrapper.objectmapper.blackbird;

import by.mark.primitivevswrapper.objectmapper.LotsOPrimitivesByConstructor;
import by.mark.primitivevswrapper.objectmapper.LotsOfWrappersByConstructor;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_EXCEEDED_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_WITHIN_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.blackbird.BlackbirdBenchmarkUtils.readValue;

@SuppressWarnings("unused")
public class PrimitiveVsWrapperDeserializationBlackbirdBenchmarkByConstructor {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappersByConstructor ___deserializeObjectWithALotOfWrappersWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappersByConstructor.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappersByConstructor ___deserializeObjectWithALotOfWrappersExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappersByConstructor.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitivesByConstructor ___deserializeObjectWithALotOfPrimitivesWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitivesByConstructor.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitivesByConstructor ___deserializeObjectWithALotOfPrimitivesExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitivesByConstructor.class);
    }
}
