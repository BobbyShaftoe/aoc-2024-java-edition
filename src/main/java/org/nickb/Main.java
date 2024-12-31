import org.nickb.aoc.Day1;
import org.nickb.aoc.Day2;
import org.nickb.aoc.Day3;

/**
 * Instead of bowing to pressure from the community and providing these functions, the JDK developers had a better idea...
 * LOL Oracle <br>
 * <a href="https://www.happycoders.eu/java/stream-gatherers/">java/stream-gatherers</a><br><br>
 * OMG - Where has this disappeared to?  :p <pre><code>Public Static Void Main String[] args</code></pre>
 * <a href="https://www.happycoders.eu/java/java-23-features/">java-23-features</a>
 */
void main() throws RuntimeException {
    System.out.print("\n***************************\n*** Advent of Code 2024 ***\n***************************\n");

    Day1 aocDay1 = new Day1("src/main/resources/day1.txt");
    int aocDay1Part1Result = aocDay1.HistorianHysteriaPart1();
    System.out.printf("  The answer is total distance = %d\n", aocDay1Part1Result);

    int aocDay1Part2Result = aocDay1.HistorianHysteriaPart2();
    System.out.printf("  The answer is total similarity score = %d\n", aocDay1Part2Result);

    Day2 aocDay2 = new Day2("src/main/resources/day2.txt");
    int aocDay2Part1Result = aocDay2.RedNosedReportsPart1();
    System.out.printf("  The answer is total safe reports = %d\n", aocDay2Part1Result);

    int aocDay2Part2Result = aocDay2.RedNosedReportsPart2();
    System.out.printf("  The answer is total adjusted safe reports = %d\n", aocDay2Part2Result);

    Day3 aocDay3 = new Day3("src/main/resources/day3.txt");
    int aocDay3Part1Result = aocDay3.MullItOverPart1();
    System.out.printf("  The answer is total sum of multiplications = %d\n", aocDay3Part1Result);

    int aocDay3Part2Result = aocDay3.MullItOverPart2();
    System.out.printf("  The answer is total sum of enabled multiplications = %d\n", aocDay3Part2Result);


}





