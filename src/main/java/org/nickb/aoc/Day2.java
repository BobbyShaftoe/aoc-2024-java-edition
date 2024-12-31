package org.nickb.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.nickb.util.Config;
import org.nickb.util.IOUtil;

public class Day2 {

    private final Boolean DEBUG_LOCAL = false;

    String fileData;
    ArrayList<List<Integer>> dataList;

    /**
     * Main constructor for this class. Initialization requires a file path to the data file.
     *
     * @param filePath
     *         the path to the data file that will be loaded and used by class methods
     */
    public Day2(String filePath) {
        this.fileData = IOUtil.readFileAsString(filePath);

        this.dataList = fileData
                .lines()
                .map(line -> Arrays.stream(line.split("\\s+"))
                        .map(Integer::parseInt)
                        .toList())
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Checks if the list of numbers is either entirely non-decreasing or non-increasing.
     *
     * @param numbers
     *         the list of integers to check
     *
     * @return true if the list is either non-decreasing or non-increasing, false otherwise
     */
    public static boolean isIncreasingOrDecreasing(List<Integer> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> numbers.get(i) <= numbers.get(i + 1)) ||
                IntStream.range(0, numbers.size() - 1)
                        .allMatch(i -> numbers.get(i) >= numbers.get(i + 1));
    }

    /**
     * Checks if the absolute difference between any two adjacent numbers in the list is at most 3 and at least 1.
     *
     * @param numbers
     *         the list of integers to check
     *
     * @return true if the absolute difference between any two adjacent numbers is <= 3 and >= 1, False otherwise
     */
    public static boolean isNumberDifferenceOk(List<Integer> numbers) {
        return IntStream.range(0, numbers.size() - 1)
                .allMatch(i -> {
                    int diff = Math.abs(numbers.get(i) - numbers.get(i + 1));
                    return diff <= 3 && diff >= 1;
                });
    }


    /**
     * Generates permutations of the input list by removing one element at a time.
     *
     * @param list
     *         the input list of integers
     *
     * @return a list of permutations, each missing one element from the original list
     */
    public static List<List<Integer>> generatePermutations(List<Integer> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> {
                    List<Integer> permutation = new ArrayList<>(list);
                    permutation.remove(i);
                    return permutation;
                })
                .collect(Collectors.toList());
    }


    /**
     * Processes the data list to count the number of valid sequences. A valid sequence is one where the levels are
     * either all increasing or all decreasing, and any two adjacent levels differ by at least one and at most three.
     *
     * @return the count of valid sequences
     */
    public int RedNosedReportsPart1() {
        System.out.print("\n  Day 2 (part 1): Red-Nosed Reports\n");

        // reduce() operation here is essentially the same as sum().
        // Also, we could just use the count() method to return a Long, instead of mapToInt() and reduce()
        // Reduction operations are better for parallel streams, and may come in handy later.
        int sum = dataList.stream()
                .filter(Day2::isIncreasingOrDecreasing)
                .filter(Day2::isNumberDifferenceOk)
                .mapToInt(_ -> 1)
                .reduce(0, Integer::sum);

        if (Config.DEBUG || DEBUG_LOCAL) {
            System.out.println(dataList);
        }

        return sum;
    }


    /**
     * Processes the data list to count the number of valid sequences as above, with an additional operation to iterate
     * over each list, sequentially removing each element and providing that to the validation logic.<hr>
     * <br>
     * A further note on <code>reduce()</code><br> As a terminal operation the key abstraction is a stream.
     * From<code>IntStream</code>interface<br><br> The classes: <code>Stream, IntStream, LongStream, DoubleStream</code>
     * are streams over objects and the primitive <code>int, long, double</code> types.
     * <p><b>Streams differ from collections in several ways:</b></p>
     * <ul>
     * <li>No storage. A stream is not a data structure that stores elements; instead, it conveys elements from a source such as a data structure, an array, a generator function, or an I/ O channel, through a pipeline of computational operations.
     * <li>Functional in nature. An operation on a stream produces a result, but does not modify its source. For example, filtering a Stream obtained from a collection produces a new Stream without the filtered elements, rather than removing elements from the source collection.
     * <li>Laziness-seeking. Many stream operations, such as filtering, mapping, or duplicate removal, can be implemented lazily, exposing opportunities for optimization. For example, "find the first String with three consecutive vowels" need not examine all the input strings. Stream operations are divided into intermediate (Stream-producing) operations and terminal (value- or side-effect-producing) operations. Intermediate operations are always lazy.
     * <li>Possibly unbounded. While collections have a finite size, streams need not. Short-circuiting operations such as:
     * <code>limit(n)</code> or <code>findFirst()</code> can allow computations on infinite streams to complete in finite time.
     * <li>Consumable. The elements of a stream are only visited once during the life of a stream.
     * Like an <code>java.util.Iterator</code>, a new stream must be generated to revisit the same elements of the source.
     * </ul>
     * <br>
     *
     * @return a sum
     */
    public int RedNosedReportsPart2() {
        System.out.print("\n  Day 2 (part 2): Red-Nosed Reports\n");

        // It's nice that we can use a predefined method here as the stream source within any map() method
        // This removes the need to predefine a variable, within the scope of a lambda operation,
        // and therefore also removes the need to use a closure within the mapToInt() method.
        int sum = dataList.stream()
                .mapToInt(x -> generatePermutations(x).stream()
                        .filter(Day2::isIncreasingOrDecreasing)
                        .anyMatch(Day2::isNumberDifferenceOk) ? 1 : 0)
                .sum();

        if (Config.DEBUG || DEBUG_LOCAL) {
            System.out.println(dataList.stream().map(Day2::generatePermutations).collect(Collectors.toList()));
            System.out.println("Sum is: " + sum);
            Notes();
        }

        return sum;
    }


    /**
     * A further note on <code>stream()</code> to come back to, because we're using <code>reduce()</code> that is from
     * the <code>IntStream</code> interface.<br>
     * <br>
     * <p><b>Streams can be obtained in a number of ways. Some examples include:</b></p>
     * <ul>
     * <li>From a <code>java.util.Collection</code> via the <code>stream()</code> and parallel<code>Stream()</code> methods;
     * <li>From an array via <code>java.util.Arrays.stream(Object[])</code>;
     * <li>From static factory methods on the stream classes, such as <code>Stream.of(Object[]), IntStream.range(int, int) or Stream.iterate(Object, UnaryOperator)</code>;
     * <li>The lines of a file can be obtained from <code>java.io.BufferedReader.lines()</code>;
     * <li>Streams of file paths can be obtained from methods in <code>java.nio.file.Files</code>;
     * <li>Streams of random numbers can be obtained from <code>java.util.Random.ints()</code>;
     * </ul>
     * Numerous other stream-bearing methods in the JDK, including:<br>
     * <code>java.util.BitSet.stream()</code>,
     * <code>java.util.regex.Pattern.splitAsStream(CharSequence)</code>, and
     * <code>java.util.jar.JarFile.stream()</code>.
     * <br>
     */
    private void Notes() {
        if (Config.DEBUG || DEBUG_LOCAL) {
            System.out.println("\nCheck all the docs in Day2.java to read about the stream() interface because we're using reduce()\n");
        }
    }

}
