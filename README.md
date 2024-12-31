# Advent of Code 2024


<!-- TOC -->
* [Advent of Code 2024](#advent-of-code-2024)
  * [Lang](#lang)
  * [Overview](#overview)
  * [Results!](#results)
    * [Day 1: Historian Hysteria - Part 1](#day-1-historian-hysteria---part-1)
    * [Day 1: Historian Hysteria - Part 2](#day-1-historian-hysteria---part-2)
    * [Day 2: Red-Nosed Reports - Part 1](#day-2-red-nosed-reports---part-1)
    * [Day 2: Red-Nosed Reports - Part 2](#day-2-red-nosed-reports---part-2)
    * [Day 3: Mull It Over - Part 1](#day-3-mull-it-over---part-1)
    * [Day 3: Mull It Over - Part 2](#day-3-mull-it-over---part-2)
  * [References](#references)
    * [Java Streams](#java-streams)
    * [Java solutions to AoC 2022](#java-solutions-to-aoc-2022)
    * [Miscellaneous references and notes](#miscellaneous-references-and-notes)
  * [Errata](#errata)
<!-- TOC -->


## Lang
This Advent of Code attempt is written in Java 23.0.1


## Overview
Here's my attempt at the Advent of Code 2024. I'm using Java 23.0.1, IntelliJ IDEA 2024 & Copilot (only for language help and boilerplate)

Overall, the main approach is functional programming as much as possible; i.e. the Streams API and other language features.
My idea was also to leverage Java 21+ features at every opportunity, such as the new switch expressions and pattern matching.




## Results!

```Bash
D:\Lib\jdk-23.0.1\bin\java.exe --enable-preview 
"-javaagent:C:\Users\Kings\AppData\Local\Programs\IntelliJ IDEA Ultimate\..." 
  -Dfile.encoding=UTF-8 
  -classpath C:\Users\Kings\Documents\Projects\AoC\2024\aoc2024\target\classes... 
  Main

***************************
*** Advent of Code 2024 ***
***************************
```


### Day 1: Historian Hysteria - Part 1
[https://adventofcode.com/2024/day/1](https://adventofcode.com/2024/day/1)
```Bash
  Day 1 (part 1): Historian Hysteria  
  The answer is total distance = 1579939
```

<img height="45%" src="src/main/resources/static/aoc-day-1-part-1-success.PNG" width="45%"/>


### Day 1: Historian Hysteria - Part 2
```Bash
  Day 1 (part 2): Historian Hysteria  
  The answer is total similarity score = 20351745
```

<img height="45%" src="src/main/resources/static/aoc-day-1-part-2-success.PNG" width="45%"/>

---

### Day 2: Red-Nosed Reports - Part 1
[https://adventofcode.com/2024/day/2](https://adventofcode.com/2024/day/2)
```Bash
  Day 2 (part 1): Red-Nosed Reports
  The answer is total safe reports = 356
```

<img height="45%" src="src/main/resources/static/aoc-day-2-part-1-success.PNG" width="45%"/>


### Day 2: Red-Nosed Reports - Part 2
```Bash
  Day 2 (part 2): Red-Nosed Reports
  The answer is total adjusted safe reports = 413
```

<img height="45%" src="src/main/resources/static/aoc-day-2-part-2-success.PNG" width="45%"/>


---

### Day 3: Mull It Over - Part 1
[https://adventofcode.com/2024/day/3](https://adventofcode.com/2024/day/3)
```Bash
  Day 3 (part 1): Mull It Over
  The answer is total sum of multiplications = 169021493
```

<img height="45%" src="src/main/resources/static/aoc-day-3-part-1-success.PNG" width="45%"/>


### Day 3: Mull It Over - Part 2
```Bash
  Day 3 (part 2): Mull It Over
  The answer is = 0
```





---

## References
This is a bunch of references mostly about functional programming and using Streams API in Java 21+
### Java Streams
- https://medium.com/javarevisited/whats-new-with-java-23-698762aa44d1
- https://stackify.com/streams-guide-java-8/
- https://bell-sw.com/blog/a-guide-to-java-stream-api/
- https://www.happycoders.eu/java/stream-gatherers/

### Java solutions to AoC 2022
- https://www.happycoders.eu/algorithms/advent-of-code-2022/

### Miscellaneous references and notes
- Some window and groupby examples in Java, Python, R and Scala
  - https://spark.apache.org/docs/3.5.2/structured-streaming-programming-guide.html#basic-operations---selection-projection-aggregation
- Stuff from the vavr guy about the vavr package and functional programming in Java
  - https://www.youtube.com/watch?v=1OpAgZvYXLQ
  - https://docs.vavr.io/
  - https://gtrefs.github.io/code/functional-fizzbuzz/


## Errata
There's a good chance I will not complete all the days, but what days I do complete I will also replicate in separate projects based on Python and Go. 
This is to compare similar approaches to the same problems with different languages. 

EOF