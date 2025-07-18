package practice;

import java.util.Arrays;
import java.util.List;

public class StreamVsParellelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20);

        // Sequential stream
        long sequentialSum = numbers.stream().reduce(0, Integer::sum);

        System.out.println(sequentialSum);
        // Parallel stream
        long parallelSum = numbers.parallelStream().reduce(0, Integer::sum);
        System.out.println(parallelSum);

        // Non-associative subtraction (result varies based on execution order)
        int wrongResult = numbers.parallelStream().reduce(0, (a, b) -> a + b);
        System.out.println(wrongResult);

        System.out.println();

        numbers.parallelStream().forEach(System.out::println);
        System.out.println("================");
        numbers.stream().forEach(System.out::println);
    }
}
