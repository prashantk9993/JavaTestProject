package practice;

import java.util.stream.Stream;

public class StreamInfiniteDemo {

    public static void main(String[] args) {
        Stream.iterate(1, n -> n * 2)
                .takeWhile(n -> n < 1000)  // Java 9+ (stops when condition becomes false)
                .forEach(System.out::println);

        Stream.generate(() -> "infinite")
                .limit(100)  // Take only first 100 elements
                .forEach(System.out::println);
    }
}
