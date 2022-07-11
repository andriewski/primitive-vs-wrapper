package by.mark.primitivevswrapper.base;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;

@SuppressWarnings("unused")
public class BaseOperationsBenchmark {

    private static final Integer[] INTEGERS_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final Integer[] INTEGERS_2 = {201, 202, 203, 204, 205, 206, 207, 208, 209, 210};

    private static final int[] INTS_1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private static final int[] INTS_2 = {201, 202, 203, 204, 205, 206, 207, 208, 209, 210};

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___sumIntegersWithinByteCache___() {
        Integer result = null;

        for (Integer integer : INTEGERS_1) {
            result = integer + integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___sumIntegersExceededByteCache___() {
        Integer result = null;

        for (Integer integer : INTEGERS_2) {
            result = integer + integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___sumPrimitiveIntsWithinByteCache___() {
        int result = 0;

        for (int integer : INTS_1) {
            result = integer + integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___sumPrimitiveIntsExceededByteCache___() {
        int result = 0;

        for (int integer : INTS_2) {
            result = integer + integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___minusIntegersWithinByteCache___() {
        Integer result = null;

        for (int i = 1; i < INTEGERS_1.length; i++) {
            result = INTEGERS_1[i] - INTEGERS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___minusIntegersExceededByteCache___() {
        Integer result = null;

        for (int i = 1; i < INTEGERS_2.length; i++) {
            result = INTEGERS_1[i] - INTEGERS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___minusPrimitiveIntsWithinByteCache___() {
        int result = 0;

        for (int i = 1; i < INTS_1.length; i++) {
            result = INTS_1[i] - INTS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___minusPrimitiveIntsExceededByteCache___() {
        int result = 0;

        for (int i = 1; i < INTS_2.length; i++) {
            result = INTS_2[i] - INTS_2[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___multiplyIntegersWithinByteCache___() {
        Integer result = null;

        for (Integer integer : INTEGERS_1) {
            result = integer * integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___multiplyIntegersExceededByteCache___() {
        Integer result = null;

        for (Integer integer : INTEGERS_2) {
            result = integer * integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___multiplyPrimitiveIntsWithinByteCache___() {
        int result = 0;

        for (int integer : INTS_1) {
            result = integer * integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___multiplyPrimitiveIntsExceededByteCache___() {
        int result = 0;

        for (int integer : INTS_2) {
            result = integer * integer;
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___divideIntegersWithinByteCache___() {
        Integer result = null;

        for (int i = 1; i < INTEGERS_1.length; i++) {
            result = INTEGERS_1[i] / INTEGERS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public Integer ___divideIntegersExceededByteCache___() {
        Integer result = null;

        for (int i = 1; i < INTEGERS_2.length; i++) {
            result = INTEGERS_1[i] / INTEGERS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___dividePrimitiveIntsWithinByteCache___() {
        int result = 0;

        for (int i = 1; i < INTS_1.length; i++) {
            result = INTS_1[i] / INTS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public int ___dividePrimitiveIntsExceededByteCache___() {
        int result = 0;

        for (int i = 1; i < INTS_2.length; i++) {
            result = INTS_2[i] / INTS_2[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean ___equalsIntegersWithinByteCache___() {
        boolean result = false;

        for (int i = 1; i < INTEGERS_1.length; i++) {
            result = INTEGERS_1[i].equals(INTEGERS_1[i - 1]);
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean ___equalsIntegersExceededByteCache___() {
        boolean result = false;

        for (int i = 1; i < INTEGERS_2.length; i++) {
            result = INTEGERS_1[i].equals(INTEGERS_1[i - 1]);
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean ___equalsPrimitiveIntsWithinByteCache___() {
        boolean result = false;

        for (int i = 1; i < INTS_1.length; i++) {
            result = INTS_1[i] == INTS_1[i - 1];
        }

        return result;
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public boolean ___equalsPrimitiveIntsExceededByteCache___() {
        boolean result = false;

        for (int i = 1; i < INTS_2.length; i++) {
            result = INTS_2[i] == INTS_2[i - 1];
        }

        return result;
    }
}
