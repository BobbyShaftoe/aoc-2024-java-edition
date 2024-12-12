import org.nickb.aoc.Day1;
import org.nickb.aoc.Day2;

/**
 * Instead of bowing to pressure from the community and providing these functions, the JDK developers had a better idea...
 * LOL Oracle <br>
 * <a href="https://www.happycoders.eu/java/stream-gatherers/">java/stream-gatherers</a><br><br>
 * OMG - Where has this disappeared to?  :p <pre><code>Public Static Void Main String[] args</code></pre>
 * <a href="https://www.happycoders.eu/java/java-23-features/">java-23-features</a>
 */
void main() throws RuntimeException {
    System.out.print("\n***************************\n*** Advent of Code 2024 ***\n***************************\n");

    Day1 aocDay1 = new Day1();
    int aoc_day1_result = aocDay1.HistorianHysteria("src/main/resources/day1.txt");
    System.out.printf("  The answer is total distance = %d\n", aoc_day1_result);
}





