package stream.deep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
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

        //-------------------
        int[] arra = IntStream.range(1,10).toArray();
        System.out.println(arra.length);
        for (int i=0 ; i < arra.length; i++){
            System.out.print(arra[i]+" ");
        }

        List<Integer> lst2 = IntStream.rangeClosed(1,10)
                .boxed()
                .toList(); // new improvement, older is .collect(Collectors.toList())
        System.out.println(lst2);

        //---------VIMP----------

        Map<String,List<Integer>>  map1 = IntStream.rangeClosed(123,200)
                .boxed()
                .collect(Collectors.groupingBy(num -> num%2==0 ? "Even" : "Odd"));
        map1.forEach((a,b) -> System.out.println(a+" "+b));

        //------------Filter -------

        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");
        List<String> fnames = names.stream().filter(n -> n.startsWith("J")).toList();
        System.out.println(fnames);
        //-------------------

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("a", "b", "c"),
                Arrays.asList("d", "e", "f")
        );
        System.out.println(nestedList);
        List<String> flatList = nestedList.stream().flatMap(List::stream).toList();
        System.out.println(flatList);
        //-------------------
        List<String> names2 = Arrays.asList("John", "Jane", "Adam", "Eve");
        List<String> names3 = names2.stream().sorted().toList();
        System.out.println(names3);
        List<String> names4 = names2.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(names4);
        //-------------------
        //-------------------
        //-------------------

        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> dist = numbers.stream().distinct().toList();
        System.out.println(dist);
    }
}
