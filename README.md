# nashorn-react-jmh-microbenchmark
Java Microbenchmark Harness (jmh) test for server-side rendering of a simple react component using Java 8's Nashorn.

## Running the benchmark
Compiling the benchmark
```
$ mvn clean install
```
After the build is done, you will get the self-contained executable JAR, which holds your benchmark, and all essential JMH infrastructure code.

Running the ReactMicroBenchmark
```
$ java -jar target/benchmarks.jar
```

## Perfomance Results
With version 1.8.0_31 react rendering time is below 1ms after warmup.  With  versions 1.8.0_40 and later the Java HotSpot Performance Engine is not able to optimize beyond ~20 ms rendering time.

### jdk1.8.0_31.jdk Summary
```
Benchmark                             Mode    Cnt     Score    Error  Units
ReactMicroBenchmark.microbenchmark   thrpt     10  1663.805 ± 96.206  ops/s
ReactMicroBenchmark.microbenchmark    avgt     10     0.597 ±  0.107  ms/op
ReactMicroBenchmark.microbenchmark  sample  17565     0.571 ±  0.004  ms/op
ReactMicroBenchmark.microbenchmark      ss     10    23.709 ± 10.169  ms/op
```
### jdk1.8.0_40.jdk Summary
```
Benchmark                             Mode  Cnt   Score   Error  Units
ReactMicroBenchmark.microbenchmark   thrpt   10  44.644 ± 2.324  ops/s
ReactMicroBenchmark.microbenchmark    avgt   10  25.724 ± 4.343  ms/op
ReactMicroBenchmark.microbenchmark  sample  432  23.529 ± 0.353  ms/op
ReactMicroBenchmark.microbenchmark      ss   10  23.000 ± 1.929  ms/op
```
### jdk1.8.0_60.jdk Summary
```
Benchmark                             Mode  Cnt   Score   Error  Units
ReactMicroBenchmark.microbenchmark   thrpt   10  41.344 ± 3.987  ops/s
ReactMicroBenchmark.microbenchmark    avgt   10  22.747 ± 2.973  ms/op
ReactMicroBenchmark.microbenchmark  sample  468  21.642 ± 0.372  ms/op
ReactMicroBenchmark.microbenchmark      ss   10  24.543 ± 3.448  ms/op
```

### Detailed Output

#### jdk1.8.0_31.jdk
```
$ export JAVA_HOME="`/usr/libexec/java_home -v '1.8.0_31'`"
$ java -jar target/benchmarks.jar

# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_31, VM 25.31-b07
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7532 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 0.00% complete, ETA 00:01:30
# Fork: 1 of 1
# Warmup Iteration   1: 18.750 ops/s
# Warmup Iteration   2: 52.656 ops/s
# Warmup Iteration   3: 85.581 ops/s
# Warmup Iteration   4: 195.365 ops/s
# Warmup Iteration   5: 337.901 ops/s
# Warmup Iteration   6: 871.423 ops/s
# Warmup Iteration   7: 1076.020 ops/s
# Warmup Iteration   8: 1230.032 ops/s
# Warmup Iteration   9: 1260.694 ops/s
# Warmup Iteration  10: 1561.413 ops/s
# Warmup Iteration  11: 1723.570 ops/s
# Warmup Iteration  12: 1691.493 ops/s
# Warmup Iteration  13: 1718.540 ops/s
# Warmup Iteration  14: 1611.977 ops/s
# Warmup Iteration  15: 1666.014 ops/s
# Warmup Iteration  16: 1688.645 ops/s
# Warmup Iteration  17: 1743.352 ops/s
# Warmup Iteration  18: 1455.067 ops/s
# Warmup Iteration  19: 1418.444 ops/s
# Warmup Iteration  20: 1708.217 ops/s
Iteration   1: 1705.828 ops/s
Iteration   2: 1661.019 ops/s
Iteration   3: 1701.513 ops/s
Iteration   4: 1739.755 ops/s
Iteration   5: 1697.024 ops/s
Iteration   6: 1661.072 ops/s
Iteration   7: 1574.010 ops/s
Iteration   8: 1532.524 ops/s
Iteration   9: 1696.079 ops/s
Iteration  10: 1669.223 ops/s


Result "microbenchmark":
  1663.805 ±(99.9%) 96.206 ops/s [Average]
  (min, avg, max) = (1532.524, 1663.805, 1739.755), stdev = 63.634
  CI (99.9%): [1567.599, 1760.011] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_31, VM 25.31-b07
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7532 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 33.32% complete, ETA 00:01:04
# Fork: 1 of 1
# Warmup Iteration   1: 46.144 ms/op
# Warmup Iteration   2: 19.119 ms/op
# Warmup Iteration   3: 11.212 ms/op
# Warmup Iteration   4: 5.345 ms/op
# Warmup Iteration   5: 3.011 ms/op
# Warmup Iteration   6: 1.250 ms/op
# Warmup Iteration   7: 0.859 ms/op
# Warmup Iteration   8: 0.780 ms/op
# Warmup Iteration   9: 0.768 ms/op
# Warmup Iteration  10: 0.659 ms/op
# Warmup Iteration  11: 0.599 ms/op
# Warmup Iteration  12: 0.577 ms/op
# Warmup Iteration  13: 0.583 ms/op
# Warmup Iteration  14: 0.571 ms/op
# Warmup Iteration  15: 0.561 ms/op
# Warmup Iteration  16: 0.559 ms/op
# Warmup Iteration  17: 0.578 ms/op
# Warmup Iteration  18: 0.585 ms/op
# Warmup Iteration  19: 0.558 ms/op
# Warmup Iteration  20: 0.548 ms/op
Iteration   1: 0.554 ms/op
Iteration   2: 0.767 ms/op
Iteration   3: 0.680 ms/op
Iteration   4: 0.574 ms/op
Iteration   5: 0.590 ms/op
Iteration   6: 0.561 ms/op
Iteration   7: 0.565 ms/op
Iteration   8: 0.565 ms/op
Iteration   9: 0.548 ms/op
Iteration  10: 0.562 ms/op


Result "microbenchmark":
  0.597 ±(99.9%) 0.107 ms/op [Average]
  (min, avg, max) = (0.548, 0.597, 0.767), stdev = 0.071
  CI (99.9%): [0.490, 0.704] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_31, VM 25.31-b07
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7532 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 66.64% complete, ETA 00:00:32
# Fork: 1 of 1
# Warmup Iteration   1: n = 20, mean = 50 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 30, 153, 250, 254, 254, 254, 254 ms/op
# Warmup Iteration   2: n = 55, mean = 18 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 14, 17, 22, 31, 39, 39, 39, 39 ms/op
# Warmup Iteration   3: n = 95, mean = 11 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 6, 10, 15, 16, 19, 19, 19, 19 ms/op
# Warmup Iteration   4: n = 213, mean = 5 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 4, 5, 6, 6, 7, 7, 7, 7 ms/op
# Warmup Iteration   5: n = 389, mean = 3 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 2, 3, 4, 5, 11, 11, 11 ms/op
# Warmup Iteration   6: n = 668, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 1, 2, 2, 2, 10, 10, 10 ms/op
# Warmup Iteration   7: n = 856, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 1, 2, 2, 3, 19, 19, 19 ms/op
# Warmup Iteration   8: n = 1068, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 1, 1, 1, 2, 10, 10, 10 ms/op
# Warmup Iteration   9: n = 1096, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 1, 1, 1, 2, 9, 9, 9 ms/op
# Warmup Iteration  10: n = 1262, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 1, 1, 1, 1, 1, 9, 9, 9 ms/op
# Warmup Iteration  11: n = 1635, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 8, 8, 8 ms/op
# Warmup Iteration  12: n = 1784, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 4, 7, 7 ms/op
# Warmup Iteration  13: n = 1731, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 3, 3, 3 ms/op
# Warmup Iteration  14: n = 1688, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 4, 4, 4 ms/op
# Warmup Iteration  15: n = 1777, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 3, 3 ms/op
# Warmup Iteration  16: n = 1830, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 0, 1, 1, 1, 2, 3, 3 ms/op
# Warmup Iteration  17: n = 1906, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 0, 1, 1, 1, 2, 2, 2 ms/op
# Warmup Iteration  18: n = 1877, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 0, 1, 1, 1, 3, 3, 3 ms/op
# Warmup Iteration  19: n = 1820, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 4, 4, 4 ms/op
# Warmup Iteration  20: n = 1747, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 5, 6, 6 ms/op
Iteration   1: n = 1747, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 3, 3 ms/op
Iteration   2: n = 1789, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 3, 3 ms/op
Iteration   3: n = 1871, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 0, 1, 1, 1, 2, 2, 2 ms/op
Iteration   4: n = 1820, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 3, 3, 3 ms/op
Iteration   5: n = 1576, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 4, 4, 4 ms/op
Iteration   6: n = 1805, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 4, 7, 7 ms/op
Iteration   7: n = 1491, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 2, 2 ms/op
Iteration   8: n = 1774, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 3, 3 ms/op
Iteration   9: n = 1816, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 1, 1, 1, 1, 2, 2, 2 ms/op
Iteration  10: n = 1876, mean = 1 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 0, 0, 1, 1, 1, 3, 3, 3 ms/op


Result "microbenchmark":
  0.571 ±(99.9%) 0.004 ms/op [Average]
  (min, avg, max) = (0.475, 0.571, 7.274), stdev = 0.170
  CI (99.9%): [0.567, 0.575] (assumes normal distribution)
  Samples, N = 17565
        mean =      0.571 ±(99.9%) 0.004 ms/op
         min =      0.475 ms/op
  p( 0.0000) =      0.475 ms/op
  p(50.0000) =      0.520 ms/op
  p(90.0000) =      0.691 ms/op
  p(95.0000) =      0.825 ms/op
  p(99.0000) =      1.186 ms/op
  p(99.9000) =      2.374 ms/op
  p(99.9900) =      5.105 ms/op
  p(99.9990) =      7.274 ms/op
  p(99.9999) =      7.274 ms/op
         max =      7.274 ms/op


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_31, VM 25.31-b07
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_31.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7532 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, single-shot each
# Measurement: 10 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 99.97% complete, ETA 00:00:00
# Fork: 1 of 1
# Warmup Iteration   1: 227.317 ms/op
# Warmup Iteration   2: 86.435 ms/op
# Warmup Iteration   3: 146.123 ms/op
# Warmup Iteration   4: 54.944 ms/op
# Warmup Iteration   5: 32.499 ms/op
# Warmup Iteration   6: 29.417 ms/op
# Warmup Iteration   7: 27.949 ms/op
# Warmup Iteration   8: 33.165 ms/op
# Warmup Iteration   9: 25.988 ms/op
# Warmup Iteration  10: 32.433 ms/op
# Warmup Iteration  11: 32.869 ms/op
# Warmup Iteration  12: 33.079 ms/op
# Warmup Iteration  13: 32.469 ms/op
# Warmup Iteration  14: 28.786 ms/op
# Warmup Iteration  15: 37.313 ms/op
# Warmup Iteration  16: 37.594 ms/op
# Warmup Iteration  17: 29.732 ms/op
# Warmup Iteration  18: 31.379 ms/op
# Warmup Iteration  19: 26.602 ms/op
# Warmup Iteration  20: 25.592 ms/op
Iteration   1: 23.538 ms/op
Iteration   2: 20.906 ms/op
Iteration   3: 21.918 ms/op
Iteration   4: 22.902 ms/op
Iteration   5: 22.621 ms/op
Iteration   6: 21.243 ms/op
Iteration   7: 21.717 ms/op
Iteration   8: 18.742 ms/op
Iteration   9: 21.024 ms/op
Iteration  10: 42.480 ms/op


Result "microbenchmark":
  23.709 ±(99.9%) 10.169 ms/op [Average]
  (min, avg, max) = (18.742, 23.709, 42.480), stdev = 6.726
  CI (99.9%): [13.540, 33.878] (assumes normal distribution)
  Samples, N = 10
        mean =     23.709 ±(99.9%) 10.169 ms/op
         min =     18.742 ms/op
  p( 0.0000) =     18.742 ms/op
  p(50.0000) =     21.818 ms/op
  p(90.0000) =     40.585 ms/op
  p(95.0000) =     42.480 ms/op
  p(99.0000) =     42.480 ms/op
  p(99.9000) =     42.480 ms/op
  p(99.9900) =     42.480 ms/op
  p(99.9990) =     42.480 ms/op
  p(99.9999) =     42.480 ms/op
         max =     42.480 ms/op


# Run complete. Total time: 00:01:39

Benchmark                             Mode    Cnt     Score    Error  Units
ReactMicroBenchmark.microbenchmark   thrpt     10  1663.805 ± 96.206  ops/s
ReactMicroBenchmark.microbenchmark    avgt     10     0.597 ±  0.107  ms/op
ReactMicroBenchmark.microbenchmark  sample  17565     0.571 ±  0.004  ms/op
ReactMicroBenchmark.microbenchmark      ss     10    23.709 ± 10.169  ms/op
```
#### jdk1.8.0_40.jdk
```
$ export JAVA_HOME="`/usr/libexec/java_home -v '1.8.0_40'`"
$ java -version

# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_40, VM 25.40-b25
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7533 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 0.00% complete, ETA 00:01:30
# Fork: 1 of 1
# Warmup Iteration   1: 19.379 ops/s
# Warmup Iteration   2: 36.207 ops/s
# Warmup Iteration   3: 40.765 ops/s
# Warmup Iteration   4: 44.995 ops/s
# Warmup Iteration   5: 49.665 ops/s
# Warmup Iteration   6: 46.568 ops/s
# Warmup Iteration   7: 46.217 ops/s
# Warmup Iteration   8: 43.759 ops/s
# Warmup Iteration   9: 42.747 ops/s
# Warmup Iteration  10: 47.027 ops/s
# Warmup Iteration  11: 48.226 ops/s
# Warmup Iteration  12: 50.170 ops/s
# Warmup Iteration  13: 49.593 ops/s
# Warmup Iteration  14: 50.845 ops/s
# Warmup Iteration  15: 48.720 ops/s
# Warmup Iteration  16: 42.269 ops/s
# Warmup Iteration  17: 41.503 ops/s
# Warmup Iteration  18: 36.812 ops/s
# Warmup Iteration  19: 43.579 ops/s
# Warmup Iteration  20: 41.588 ops/s
Iteration   1: 47.263 ops/s
Iteration   2: 45.891 ops/s
Iteration   3: 43.524 ops/s
Iteration   4: 42.756 ops/s
Iteration   5: 43.811 ops/s
Iteration   6: 45.685 ops/s
Iteration   7: 43.078 ops/s
Iteration   8: 46.349 ops/s
Iteration   9: 44.340 ops/s
Iteration  10: 43.747 ops/s


Result "microbenchmark":
  44.644 ±(99.9%) 2.324 ops/s [Average]
  (min, avg, max) = (42.756, 44.644, 47.263), stdev = 1.537
  CI (99.9%): [42.320, 46.969] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_40, VM 25.40-b25
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7533 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 33.32% complete, ETA 00:01:05
# Fork: 1 of 1
# Warmup Iteration   1: 43.722 ms/op
# Warmup Iteration   2: 25.456 ms/op
# Warmup Iteration   3: 22.990 ms/op
# Warmup Iteration   4: 21.692 ms/op
# Warmup Iteration   5: 25.554 ms/op
# Warmup Iteration   6: 22.186 ms/op
# Warmup Iteration   7: 19.821 ms/op
# Warmup Iteration   8: 20.844 ms/op
# Warmup Iteration   9: 22.567 ms/op
# Warmup Iteration  10: 21.047 ms/op
# Warmup Iteration  11: 20.119 ms/op
# Warmup Iteration  12: 21.277 ms/op
# Warmup Iteration  13: 24.116 ms/op
# Warmup Iteration  14: 24.546 ms/op
# Warmup Iteration  15: 22.667 ms/op
# Warmup Iteration  16: 22.599 ms/op
# Warmup Iteration  17: 24.435 ms/op
# Warmup Iteration  18: 25.892 ms/op
# Warmup Iteration  19: 26.147 ms/op
# Warmup Iteration  20: 25.478 ms/op
Iteration   1: 23.753 ms/op
Iteration   2: 23.383 ms/op
Iteration   3: 24.235 ms/op
Iteration   4: 27.146 ms/op
Iteration   5: 30.066 ms/op
Iteration   6: 27.588 ms/op
Iteration   7: 25.941 ms/op
Iteration   8: 29.999 ms/op
Iteration   9: 22.716 ms/op
Iteration  10: 22.414 ms/op


Result "microbenchmark":
  25.724 ±(99.9%) 4.343 ms/op [Average]
  (min, avg, max) = (22.414, 25.724, 30.066), stdev = 2.873
  CI (99.9%): [21.381, 30.067] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_40, VM 25.40-b25
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7533 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 66.64% complete, ETA 00:00:32
# Fork: 1 of 1
# Warmup Iteration   1: n = 18, mean = 56 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 29, 89, 490, 490, 490, 490, 490 ms/op
# Warmup Iteration   2: n = 39, mean = 26 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 25, 31, 34, 35, 35, 35, 35 ms/op
# Warmup Iteration   3: n = 44, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 23, 25, 26, 27, 27, 27, 27 ms/op
# Warmup Iteration   4: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 21, 23, 25, 25, 25, 25, 25 ms/op
# Warmup Iteration   5: n = 49, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 20, 24, 27, 30, 30, 30, 30 ms/op
# Warmup Iteration   6: n = 50, mean = 20 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 19, 22, 24, 30, 30, 30, 30 ms/op
# Warmup Iteration   7: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 20, 23, 26, 38, 38, 38, 38 ms/op
# Warmup Iteration   8: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 22, 26, 27, 29, 29, 29, 29 ms/op
# Warmup Iteration   9: n = 43, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 23, 27, 29, 34, 34, 34, 34 ms/op
# Warmup Iteration  10: n = 47, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 23, 24, 25, 25, 25, 25 ms/op
# Warmup Iteration  11: n = 49, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 23, 25, 29, 29, 29, 29 ms/op
# Warmup Iteration  12: n = 47, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 24, 28, 35, 35, 35, 35 ms/op
# Warmup Iteration  13: n = 49, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 23, 25, 35, 35, 35, 35 ms/op
# Warmup Iteration  14: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 23, 23, 25, 25, 25, 25 ms/op
# Warmup Iteration  15: n = 37, mean = 28 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 25, 36, 58, 91, 91, 91, 91 ms/op
# Warmup Iteration  16: n = 44, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 27, 29, 31, 31, 31, 31 ms/op
# Warmup Iteration  17: n = 37, mean = 28 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 27, 35, 37, 38, 38, 38, 38 ms/op
# Warmup Iteration  18: n = 34, mean = 30 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 23, 31, 35, 36, 36, 36, 36, 36 ms/op
# Warmup Iteration  19: n = 32, mean = 32 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 23, 32, 41, 44, 49, 49, 49, 49 ms/op
# Warmup Iteration  20: n = 41, mean = 25 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 25, 28, 29, 30, 30, 30, 30 ms/op
Iteration   1: n = 42, mean = 25 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 24, 28, 30, 30, 30, 30, 30 ms/op
Iteration   2: n = 43, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 24, 26, 27, 30, 30, 30, 30 ms/op
Iteration   3: n = 43, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 27, 28, 29, 29, 29, 29 ms/op
Iteration   4: n = 45, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 25, 26, 34, 34, 34, 34 ms/op
Iteration   5: n = 43, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 23, 26, 28, 37, 37, 37, 37 ms/op
Iteration   6: n = 44, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 26, 27, 30, 30, 30, 30 ms/op
Iteration   7: n = 43, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 23, 27, 27, 33, 33, 33, 33 ms/op
Iteration   8: n = 42, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 23, 27, 29, 30, 30, 30, 30 ms/op
Iteration   9: n = 43, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 23, 26, 28, 29, 29, 29, 29 ms/op
Iteration  10: n = 44, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 27, 27, 31, 31, 31, 31 ms/op


Result "microbenchmark":
  23.529 ±(99.9%) 0.353 ms/op [Average]
  (min, avg, max) = (20.611, 23.529, 37.028), stdev = 2.217
  CI (99.9%): [23.175, 23.882] (assumes normal distribution)
  Samples, N = 432
        mean =     23.529 ±(99.9%) 0.353 ms/op
         min =     20.611 ms/op
  p( 0.0000) =     20.611 ms/op
  p(50.0000) =     22.659 ms/op
  p(90.0000) =     26.447 ms/op
  p(95.0000) =     27.504 ms/op
  p(99.0000) =     30.672 ms/op
  p(99.9000) =     37.028 ms/op
  p(99.9900) =     37.028 ms/op
  p(99.9990) =     37.028 ms/op
  p(99.9999) =     37.028 ms/op
         max =     37.028 ms/op


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_40, VM 25.40-b25
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7533 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, single-shot each
# Measurement: 10 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 99.97% complete, ETA 00:00:00
# Fork: 1 of 1
# Warmup Iteration   1: 453.656 ms/op
# Warmup Iteration   2: 41.008 ms/op
# Warmup Iteration   3: 31.146 ms/op
# Warmup Iteration   4: 31.071 ms/op
# Warmup Iteration   5: 28.875 ms/op
# Warmup Iteration   6: 26.850 ms/op
# Warmup Iteration   7: 23.013 ms/op
# Warmup Iteration   8: 22.241 ms/op
# Warmup Iteration   9: 36.277 ms/op
# Warmup Iteration  10: 29.070 ms/op
# Warmup Iteration  11: 26.718 ms/op
# Warmup Iteration  12: 24.180 ms/op
# Warmup Iteration  13: 30.874 ms/op
# Warmup Iteration  14: 30.233 ms/op
# Warmup Iteration  15: 24.879 ms/op
# Warmup Iteration  16: 27.965 ms/op
# Warmup Iteration  17: 28.166 ms/op
# Warmup Iteration  18: 22.458 ms/op
# Warmup Iteration  19: 22.340 ms/op
# Warmup Iteration  20: 22.329 ms/op
Iteration   1: 20.632 ms/op
Iteration   2: 22.058 ms/op
Iteration   3: 22.830 ms/op
Iteration   4: 23.302 ms/op
Iteration   5: 23.109 ms/op
Iteration   6: 23.179 ms/op
Iteration   7: 23.218 ms/op
Iteration   8: 24.120 ms/op
Iteration   9: 25.431 ms/op
Iteration  10: 22.117 ms/op


Result "microbenchmark":
  23.000 ±(99.9%) 1.929 ms/op [Average]
  (min, avg, max) = (20.632, 23.000, 25.431), stdev = 1.276
  CI (99.9%): [21.071, 24.928] (assumes normal distribution)
  Samples, N = 10
        mean =     23.000 ±(99.9%) 1.929 ms/op
         min =     20.632 ms/op
  p( 0.0000) =     20.632 ms/op
  p(50.0000) =     23.144 ms/op
  p(90.0000) =     25.300 ms/op
  p(95.0000) =     25.431 ms/op
  p(99.0000) =     25.431 ms/op
  p(99.9000) =     25.431 ms/op
  p(99.9900) =     25.431 ms/op
  p(99.9990) =     25.431 ms/op
  p(99.9999) =     25.431 ms/op
         max =     25.431 ms/op


# Run complete. Total time: 00:01:41

Benchmark                             Mode  Cnt   Score   Error  Units
ReactMicroBenchmark.microbenchmark   thrpt   10  44.644 ± 2.324  ops/s
ReactMicroBenchmark.microbenchmark    avgt   10  25.724 ± 4.343  ms/op
ReactMicroBenchmark.microbenchmark  sample  432  23.529 ± 0.353  ms/op
ReactMicroBenchmark.microbenchmark      ss   10  23.000 ± 1.929  ms/op
```
#### jdk1.8.0_60.jdk
```
# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_60, VM 25.60-b23
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Throughput, ops/time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 0.00% complete, ETA 00:01:30
# Fork: 1 of 1
# Warmup Iteration   1: 20.601 ops/s
# Warmup Iteration   2: 35.520 ops/s
# Warmup Iteration   3: 41.410 ops/s
# Warmup Iteration   4: 41.112 ops/s
# Warmup Iteration   5: 40.794 ops/s
# Warmup Iteration   6: 34.487 ops/s
# Warmup Iteration   7: 37.739 ops/s
# Warmup Iteration   8: 38.038 ops/s
# Warmup Iteration   9: 38.380 ops/s
# Warmup Iteration  10: 38.599 ops/s
# Warmup Iteration  11: 38.484 ops/s
# Warmup Iteration  12: 39.935 ops/s
# Warmup Iteration  13: 34.566 ops/s
# Warmup Iteration  14: 36.852 ops/s
# Warmup Iteration  15: 35.521 ops/s
# Warmup Iteration  16: 41.043 ops/s
# Warmup Iteration  17: 43.211 ops/s
# Warmup Iteration  18: 43.258 ops/s
# Warmup Iteration  19: 43.414 ops/s
# Warmup Iteration  20: 44.293 ops/s
Iteration   1: 38.277 ops/s
Iteration   2: 43.077 ops/s
Iteration   3: 36.758 ops/s
Iteration   4: 44.327 ops/s
Iteration   5: 39.837 ops/s
Iteration   6: 39.290 ops/s
Iteration   7: 42.122 ops/s
Iteration   8: 43.767 ops/s
Iteration   9: 43.955 ops/s
Iteration  10: 42.027 ops/s


Result "microbenchmark":
  41.344 ±(99.9%) 3.987 ops/s [Average]
  (min, avg, max) = (36.758, 41.344, 44.327), stdev = 2.637
  CI (99.9%): [37.356, 45.331] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_60, VM 25.60-b23
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 33.32% complete, ETA 00:01:05
# Fork: 1 of 1
# Warmup Iteration   1: 58.919 ms/op
# Warmup Iteration   2: 28.752 ms/op
# Warmup Iteration   3: 22.349 ms/op
# Warmup Iteration   4: 22.650 ms/op
# Warmup Iteration   5: 23.542 ms/op
# Warmup Iteration   6: 21.956 ms/op
# Warmup Iteration   7: 23.106 ms/op
# Warmup Iteration   8: 25.499 ms/op
# Warmup Iteration   9: 24.395 ms/op
# Warmup Iteration  10: 23.413 ms/op
# Warmup Iteration  11: 23.178 ms/op
# Warmup Iteration  12: 22.337 ms/op
# Warmup Iteration  13: 23.004 ms/op
# Warmup Iteration  14: 22.425 ms/op
# Warmup Iteration  15: 26.666 ms/op
# Warmup Iteration  16: 27.596 ms/op
# Warmup Iteration  17: 25.130 ms/op
# Warmup Iteration  18: 24.370 ms/op
# Warmup Iteration  19: 22.546 ms/op
# Warmup Iteration  20: 21.888 ms/op
Iteration   1: 27.092 ms/op
Iteration   2: 22.937 ms/op
Iteration   3: 25.143 ms/op
Iteration   4: 20.944 ms/op
Iteration   5: 22.369 ms/op
Iteration   6: 21.433 ms/op
Iteration   7: 21.169 ms/op
Iteration   8: 21.386 ms/op
Iteration   9: 23.024 ms/op
Iteration  10: 21.969 ms/op


Result "microbenchmark":
  22.747 ±(99.9%) 2.973 ms/op [Average]
  (min, avg, max) = (20.944, 22.747, 27.092), stdev = 1.966
  CI (99.9%): [19.774, 25.719] (assumes normal distribution)


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_60, VM 25.60-b23
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, 1 s each
# Measurement: 10 iterations, 1 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Sampling time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 66.64% complete, ETA 00:00:32
# Fork: 1 of 1
# Warmup Iteration   1: n = 22, mean = 47 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 22, 28, 81, 316, 355, 355, 355, 355 ms/op
# Warmup Iteration   2: n = 43, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 23, 27, 27, 44, 44, 44, 44 ms/op
# Warmup Iteration   3: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 22, 25, 27, 29, 29, 29, 29 ms/op
# Warmup Iteration   4: n = 45, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 18, 22, 25, 26, 28, 28, 28, 28 ms/op
# Warmup Iteration   5: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 22, 25, 25, 26, 26, 26, 26 ms/op
# Warmup Iteration   6: n = 49, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 22, 23, 27, 27, 27, 27 ms/op
# Warmup Iteration   7: n = 47, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 22, 23, 24, 32, 32, 32, 32 ms/op
# Warmup Iteration   8: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 21, 24, 27, 37, 37, 37, 37 ms/op
# Warmup Iteration   9: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 21, 24, 24, 26, 26, 26, 26 ms/op
# Warmup Iteration  10: n = 43, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 23, 28, 30, 31, 31, 31, 31 ms/op
# Warmup Iteration  11: n = 43, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 24, 25, 26, 26, 26, 26, 26 ms/op
# Warmup Iteration  12: n = 45, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 22, 25, 27, 29, 29, 29, 29 ms/op
# Warmup Iteration  13: n = 47, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 21, 24, 29, 36, 36, 36, 36 ms/op
# Warmup Iteration  14: n = 43, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 23, 26, 27, 41, 41, 41, 41 ms/op
# Warmup Iteration  15: n = 42, mean = 24 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 23, 29, 31, 34, 34, 34, 34 ms/op
# Warmup Iteration  16: n = 47, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 21, 23, 24, 26, 26, 26, 26 ms/op
# Warmup Iteration  17: n = 45, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 21, 22, 25, 27, 31, 31, 31, 31 ms/op
# Warmup Iteration  18: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 22, 24, 25, 27, 27, 27, 27 ms/op
# Warmup Iteration  19: n = 45, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 27, 32, 38, 38, 38, 38 ms/op
# Warmup Iteration  20: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 24, 26, 36, 36, 36, 36 ms/op
Iteration   1: n = 47, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 25, 25, 26, 26, 26, 26 ms/op
Iteration   2: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 24, 25, 26, 26, 26, 26 ms/op
Iteration   3: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 24, 25, 28, 28, 28, 28 ms/op
Iteration   4: n = 44, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 23, 26, 29, 34, 34, 34, 34 ms/op
Iteration   5: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 21, 25, 26, 29, 29, 29, 29 ms/op
Iteration   6: n = 47, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 24, 29, 33, 33, 33, 33 ms/op
Iteration   7: n = 48, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 24, 25, 29, 29, 29, 29 ms/op
Iteration   8: n = 45, mean = 23 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 20, 22, 27, 30, 38, 38, 38, 38 ms/op
Iteration   9: n = 49, mean = 21 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 20, 24, 24, 26, 26, 26, 26 ms/op
Iteration  10: n = 46, mean = 22 ms/op, p{0.00, 0.50, 0.90, 0.95, 0.99, 0.999, 0.9999, 1.00} = 19, 21, 27, 28, 29, 29, 29, 29 ms/op


Result "microbenchmark":
  21.642 ±(99.9%) 0.372 ms/op [Average]
  (min, avg, max) = (19.202, 21.642, 38.339), stdev = 2.429
  CI (99.9%): [21.270, 22.014] (assumes normal distribution)
  Samples, N = 468
        mean =     21.642 ±(99.9%) 0.372 ms/op
         min =     19.202 ms/op
  p( 0.0000) =     19.202 ms/op
  p(50.0000) =     20.726 ms/op
  p(90.0000) =     24.419 ms/op
  p(95.0000) =     25.751 ms/op
  p(99.0000) =     30.906 ms/op
  p(99.9000) =     38.339 ms/op
  p(99.9900) =     38.339 ms/op
  p(99.9990) =     38.339 ms/op
  p(99.9999) =     38.339 ms/op
         max =     38.339 ms/op


# JMH 1.10.4 (released 7 days ago)
# VM version: JDK 1.8.0_60, VM 25.60-b23
# VM invoker: /Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/jre/bin/java
# VM options: -Didea.launcher.port=7534 -Didea.launcher.bin.path=/Applications/IntelliJ IDEA 14.app/Contents/bin -Dfile.encoding=UTF-8
# Warmup: 20 iterations, single-shot each
# Measurement: 10 iterations, single-shot each
# Timeout: 10 min per iteration
# Threads: 1 thread
# Benchmark mode: Single shot invocation time
# Benchmark: com.github.maximenajim.ReactMicroBenchmark.microbenchmark

# Run progress: 99.97% complete, ETA 00:00:00
# Fork: 1 of 1
# Warmup Iteration   1: 367.257 ms/op
# Warmup Iteration   2: 45.923 ms/op
# Warmup Iteration   3: 101.242 ms/op
# Warmup Iteration   4: 38.684 ms/op
# Warmup Iteration   5: 33.647 ms/op
# Warmup Iteration   6: 27.041 ms/op
# Warmup Iteration   7: 25.815 ms/op
# Warmup Iteration   8: 26.841 ms/op
# Warmup Iteration   9: 28.485 ms/op
# Warmup Iteration  10: 25.314 ms/op
# Warmup Iteration  11: 26.635 ms/op
# Warmup Iteration  12: 28.411 ms/op
# Warmup Iteration  13: 32.220 ms/op
# Warmup Iteration  14: 27.406 ms/op
# Warmup Iteration  15: 24.700 ms/op
# Warmup Iteration  16: 28.398 ms/op
# Warmup Iteration  17: 28.585 ms/op
# Warmup Iteration  18: 24.364 ms/op
# Warmup Iteration  19: 27.349 ms/op
# Warmup Iteration  20: 22.713 ms/op
Iteration   1: 23.152 ms/op
Iteration   2: 23.539 ms/op
Iteration   3: 21.722 ms/op
Iteration   4: 24.137 ms/op
Iteration   5: 22.217 ms/op
Iteration   6: 25.395 ms/op
Iteration   7: 25.359 ms/op
Iteration   8: 27.983 ms/op
Iteration   9: 28.521 ms/op
Iteration  10: 23.406 ms/op


Result "microbenchmark":
  24.543 ±(99.9%) 3.448 ms/op [Average]
  (min, avg, max) = (21.722, 24.543, 28.521), stdev = 2.281
  CI (99.9%): [21.095, 27.991] (assumes normal distribution)
  Samples, N = 10
        mean =     24.543 ±(99.9%) 3.448 ms/op
         min =     21.722 ms/op
  p( 0.0000) =     21.722 ms/op
  p(50.0000) =     23.838 ms/op
  p(90.0000) =     28.467 ms/op
  p(95.0000) =     28.521 ms/op
  p(99.0000) =     28.521 ms/op
  p(99.9000) =     28.521 ms/op
  p(99.9900) =     28.521 ms/op
  p(99.9990) =     28.521 ms/op
  p(99.9999) =     28.521 ms/op
         max =     28.521 ms/op


# Run complete. Total time: 00:01:41

Benchmark                             Mode  Cnt   Score   Error  Units
ReactMicroBenchmark.microbenchmark   thrpt   10  41.344 ± 3.987  ops/s
ReactMicroBenchmark.microbenchmark    avgt   10  22.747 ± 2.973  ms/op
ReactMicroBenchmark.microbenchmark  sample  468  21.642 ± 0.372  ms/op
ReactMicroBenchmark.microbenchmark      ss   10  24.543 ± 3.448  ms/op

Process finished with exit code 0
```
