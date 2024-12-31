package org.nickb.aoc;

import org.nickb.util.Config;
import org.nickb.util.IOUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day3 {

    private final Boolean DEBUG_LOCAL = false;

    String fileData;
    String dataList;
    String matchPattern = "mul\\([0-9]+,[0-9]+\\)";

    /**
     * Main constructor for this class. Initialization requires a file path to the data file.
     *
     * @param filePath
     *         the path to the data file that will be loaded and used by class methods
     */
    public Day3(String filePath) {
        this.fileData = IOUtil.readFileAsString(filePath);
        this.dataList = fileData;
    }


    /**
     * Extracts all matches of a given regular expression pattern from the provided data string.
     *
     * @param regexPattern
     *         the regular expression pattern to match
     * @param data
     *         the input string to search for matches
     *
     * @return a list of strings containing all matches of the regular expression pattern
     */
    private static List<String> extractData(String regexPattern, String data) {
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(data);
        return matcher.results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
    }


    /**
     * Processes the data list to extract all valid multiplication operations conforming to "/mul\([0-9]+,[0-9]+\)/" and
     * then calculate the sum of all valid multiplication operations<hr>
     *
     * @return the count of valid sequences
     */
    public int MullItOverPart1() {
        System.out.print("\n  Day 3 (part 1): Mull It Over\n");

        int sum = extractData(matchPattern, dataList)
                .stream()
                .map(s -> s.substring(4, s.length() - 1).split(","))
                .mapToInt(parts -> Integer.parseInt(parts[0]) * Integer.parseInt(parts[1]))
                .sum();


        if (Config.DEBUG || DEBUG_LOCAL) {
            System.out.println(extractData(matchPattern, dataList));
            System.out.println("Sum is: " + sum);
        }

        return sum;
    }




    public int MullItOverPart2() {
        System.out.print("\n  Day 3 (part 2): Mull It Over\n");

        int sum = 0;


        if (Config.DEBUG || DEBUG_LOCAL) {
            System.out.println(extractData(matchPattern, dataList));
            System.out.println("Sum is: " + sum);
        }

        return sum;
    }

}

