package stream.deep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreation {
    public static void main(String[] args) {

        //1. From collections
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> stream = list.stream();
        Stream<String> parallelStream = list.parallelStream();
        System.out.println("Using Collection::");
        stream.forEach(e -> System.out.print(e+" "));
        System.out.println();

        //2. From Arrays
        String[] array = {"a","b","c"};
        Stream<String> stream1 = Arrays.stream(array);
        Stream<String> partialStream1 = Arrays.stream(array,1,3);
        System.out.println("Using Arrays::");
        stream1.forEach(e -> System.out.print(e+" "));
        System.out.println();
        partialStream1.forEach(e -> System.out.print(e+" "));
        System.out.println();

        //3. From Values
        Stream<String> stream3 = Stream.of("a","b","c");
        Stream<String> stream4 = Stream.empty();
        System.out.println("Using Values::");
        stream3.forEach(e -> System.out.print(e+" "));
        System.out.println();

        //4. From Functions
        Stream<Double> stream5 = Stream.generate(Math::random).limit(10);
        Stream<Integer> stream6 = Stream.iterate(1, n -> n+1).limit(5);
        System.out.println("Using Functions::");
        stream5.forEach(e -> System.out.print(e+" "));
        stream6.forEach(e -> System.out.print(e+" "));
        System.out.println();

        //5. From Files
        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))){
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //5. From Strings
        Stream<String> stream7 = """
                Hello World
                Hello World 2
                Hello World 3
                """.lines();
        System.out.println("Using Strings::");
        stream7.forEach(e -> System.out.println(e+" "));
        System.out.println();

        IntStream charStream = "Prashant".chars();
        charStream.forEach(e -> System.out.print(e+" "));
        System.out.println();

        Stream<String> stringStream = Pattern.compile(",").splitAsStream("a,b,c,d");
        stringStream.forEach(e -> System.out.print(e+" "));
        System.out.println();

        Stream<String> str1 = Arrays.stream("Prashant".split(""));
        str1.forEach(e -> System.out.print(e+" "));
        System.out.println();
    }
}
