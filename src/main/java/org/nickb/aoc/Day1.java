package org.nickb.aoc;

import module java.base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.nickb.util.IOUtil;
import org.nickb.util.Config;

public class Day1 {

    /**
     * Calculates the absolute differences between corresponding elements of two arrays.
     *
     * @param array1 the first array of integers
     * @param array2 the second array of integers
     * @return a list of absolute differences between corresponding elements of the two arrays
     */
    public static List<Integer> calculateDifferences(int[] array1, int[] array2) {
        return IntStream.range(0, Math.min(array1.length, array2.length))
                .mapToObj(i -> Math.abs(array1[i] - array2[i]))
                .collect(Collectors.toList());
    }

    /**
     * Processes historically significant data from a file, calculates differences between two columns of locations,
     * and returns the sum of these differences.
     *
     * @param dataFilePath the path to the data file
     * @return the sum of the absolute differences between the two columns of numbers
     */
    public int HistorianHysteria(String dataFilePath) {
        System.out.print("\n  Day 1: Historian Hysteria  \n");
        String fileData = IOUtil.readFileAsString(dataFilePath);

        int[][] dataList = new int[2][];
        for (int colNum = 0; colNum < 2; colNum++) {
            int finalColNum = colNum;
            dataList[colNum] = fileData.lines()
                    .map(line -> line.split("\\s+"))
                    .mapToInt(parts -> Integer.parseInt(parts[finalColNum]))
                    .sorted()
                    .toArray();
        }

        int sum = calculateDifferences(dataList[0], dataList[1]).stream()
                .mapToInt(Integer::intValue)
                .sum();

        if (Config.DEBUG) {
            System.out.printf("differences: %s\n", calculateDifferences(dataList[0], dataList[1]));
            System.out.printf("sum: %d\n", sum);
        }

        return sum;
    }
}
