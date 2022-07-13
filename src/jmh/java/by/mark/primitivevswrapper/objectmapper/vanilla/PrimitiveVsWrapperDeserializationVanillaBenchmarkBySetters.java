package by.mark.primitivevswrapper.objectmapper.vanilla;

import by.mark.primitivevswrapper.objectmapper.LotsOPrimitivesBySetters;
import by.mark.primitivevswrapper.objectmapper.LotsOfWrappersBySetters;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_EXCEEDED_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.CommonFilesUtils.VALUES_WITHIN_BYTE_CACHE_JSON;
import static by.mark.primitivevswrapper.objectmapper.vanilla.VanillaBenchmarkUtils.readValue;

@SuppressWarnings("unused")
public class PrimitiveVsWrapperDeserializationVanillaBenchmarkBySetters {

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappersBySetters ___deserializeObjectWithALotOfWrappersWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOfWrappersBySetters.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOfWrappersBySetters ___deserializeObjectWithALotOfWrappersExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOfWrappersBySetters.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitivesBySetters ___deserializeObjectWithALotOfPrimitivesWithinByteCache___() {
        return readValue(VALUES_WITHIN_BYTE_CACHE_JSON, LotsOPrimitivesBySetters.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public LotsOPrimitivesBySetters ___deserializeObjectWithALotOfPrimitivesExceededByteCache___() {
        return readValue(VALUES_EXCEEDED_BYTE_CACHE_JSON, LotsOPrimitivesBySetters.class);
    }
}
