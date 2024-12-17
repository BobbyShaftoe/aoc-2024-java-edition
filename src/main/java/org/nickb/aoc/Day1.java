package org.nickb.aoc;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.nickb.util.IOUtil;
import org.nickb.util.Config;

public class Day1 {

    String fileData;
    int[][] dataList = new int[2][];

    /**
     * Main constructor for this class. Initialization requires a file path to the data file.
     *
     * @param filePath
     *         the path to the data file that will be loaded and used by class methods
     */
    public Day1(String filePath) {
        this.fileData = IOUtil.readFileAsString(filePath);

        for (var colNum = 0; colNum < 2; colNum++) {
            int finalColNum = colNum;
            dataList[colNum] = fileData.lines()
                    .map(line -> line.split("\\s+"))
                    .mapToInt(parts -> Integer.parseInt(parts[finalColNum]))
                    .sorted()
                    .toArray();
        }
    }

    /**
     * Calculates the absolute differences between corresponding elements of two arrays.
     *
     * @param array1
     *         the first array of integers
     * @param array2
     *         the second array of integers
     *
     * @return a list of absolute differences between corresponding elements of the two arrays
     */
    public static List<Integer> calculateDifferences(int[] array1, int[] array2) {
        return IntStream.range(0, Math.min(array1.length, array2.length))
                .mapToObj(i -> Math.abs(array1[i] - array2[i]))
                .collect(Collectors.toList());
    }

    /**
     * Counts the occurrences of each element of one array that are in another array.
     *
     * @param array1
     *         the first array of integers
     * @param array2
     *         the second array of integers
     *
     * @return a map of integers representing the count of occurrences of each element in array1 that are present in
     * array2
     */
    public static Map<Integer, Integer> countOccurrences(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .boxed()
                .collect(Collectors.toMap(
                        Function.identity(),
                        i -> (int) Arrays.stream(array2)
                                .filter(j -> j == i)
                                .count()
                ));
    }

    /**
     * Processes historically significant data from a file, calculates differences between two columns of locations as
     * integer values, and returns the sum of these differences.
     *
     * @return the sum of the absolute differences between two arrays of integers
     */
    public int HistorianHysteriaPart1() {
        System.out.print("\n  Day 1 (part 1): Historian Hysteria\n");

        int sum = calculateDifferences(dataList[0], dataList[1]).stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (Config.DEBUG) {
            System.out.printf("differences: %s\n", calculateDifferences(dataList[0], dataList[1]));
            System.out.printf("sum: %d\n", sum);
        }
        return sum;
    }


    /**
     * Processes historically significant data from a file, calculates the similarity score between two columns of
     * integers, and returns the total sum of these scores.
     *
     * @return the sum of similarity scores from two arrays of integers
     */
    public int HistorianHysteriaPart2() {
        System.out.print("\n  Day 1 (part 2): Historian Hysteria\n");

        int sum = countOccurrences(dataList[0], dataList[1]).entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();

        if (Config.DEBUG) {
            System.out.printf("occurrences: %s\n", countOccurrences(dataList[0], dataList[1]));
            System.out.printf("sum: %d\n", sum);
        }

        return sum;
    }

}

