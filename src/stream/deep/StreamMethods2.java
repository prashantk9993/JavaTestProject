package stream.deep;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMethods2 {

    public static void main(String[] args) {

        // 1. Distinct
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        System.out.println("original:::"+numbers);
        List<Integer> distinct = numbers.stream()
                .distinct().toList();
        System.out.println("distinct:::"+distinct);

        //-----------sorted------
        List<String> names = Arrays.asList("John", "Jane", "Adam", "Eve");
        List<String> sortedNames1 = names.stream().sorted().toList();
        System.out.println("sortedNames1:::"+sortedNames1);

        List<String> sortedNames2 = names.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println("sortedNames2:::"+sortedNames2);

        //---------Peek--------

        List<String> result = Stream.of("one", "two", "three")
                .filter(s -> s.length() > 3)
                .peek(s -> System.out.println("Filtered: " + s))
                .map(String::toUpperCase)
                .peek(s -> System.out.println("Mapped: " + s))
                .toList();

        //---------limit() and skip()--------
        // Find highest second last number
        List<Integer> numbers2 = Arrays.asList(16, 245, 3, 40, 5, 6, 17, 8, 9, 10);

        numbers2.stream()
                .sorted(Collections.reverseOrder())
                .skip(1)
                .limit(1)
                .peek(e-> System.out.print(e))
                .toList();

        //---------can add 2 filters ? --------
        List<Integer> numbers3 = Arrays.asList(16, 245, 3, 40, 5, 6, 17, 8, 9, 10);

        numbers3.stream()
                .filter(x-> x<= 10)
                .peek(x-> System.out.println("Filter 1:::"+x))
                .filter(x-> x>=40)
                .peek(x-> System.out.println("Filter 2:::"+x))
                .forEach(x-> System.out.println("Result:::"+x)); // empty result.

        //---------takeWhile() and dropWhile() (Java 9+)--------
        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 1, 2);

        List<Integer> taken = numbers4.stream()
                .takeWhile(n -> n < 4)
                .peek(x-> System.out.println("taken :::"+x)) // 1, 2, 3 but next 1, 2 not there
                .toList();

        List<Integer> dropped = numbers4.stream()
                .dropWhile(n -> n < 4)
                .peek(x-> System.out.println("dropped :::"+x))
                .toList();

        //--------- reduce() -------
        // 1. sum of elements
        // 2. sum of square of elements
        // 3. sum of cube of elements
        List<Integer> numbers5 = Arrays.asList(1, 2, 3, 4, 5);
        int sum  = numbers5.stream().reduce(0, (x,y) -> x + y);
        System.out.println("sum :::"+sum);

        int sumofSure  = numbers5.stream().map(n -> n * n).reduce(0, Integer::sum );
        System.out.println("sumofSure :::"+sumofSure);

        // min() and max()
        List<Integer> numbers6 = Arrays.asList(-4,1, 2, 300, 4, 5);
        Optional<Integer> min = numbers6.stream().min(Integer::compare);
        Optional<Integer> max = numbers6.stream().max(Integer::compare);

        System.out.println("min :::"+min.get()); // -4
        System.out.println("max :::"+max.get()); // 300

        // count()
        List<String> names6 = Arrays.asList("John", "Jane", "Adam");
        long count = names6.stream().count();
        System.out.println("count :::"+count);

        List<Integer> stream1 =  List.of(1,2,3,4);
        long count2 = stream1.stream().count();
        System.out.println("count2 :::"+count2);

        int[] intArray =  {1,2,3,4};
        long count3 = Arrays.stream(intArray).count();
        System.out.println("count3 :::"+count3);

        int[] arr = {1,2,3,4,5};
        Stream s1 = Stream.of(arr);
        System.out.println("Stream.of count::"+s1.count());
        IntStream s2 = IntStream.of(arr);
        System.out.println("IntStream.of count::"+s2.count());

        //VIMP : output 5 since Stream support wrappers not premitives
        Integer[] arr3 = {1,2,3,4,5};
        Stream s3 = Stream.of(arr3);
        System.out.println("For Integer Stream.of count::"+s3.count());


        // anyMatch(), allMatch(), noneMatch()
       // Short-circuiting terminal operations.

        List<Integer> numbers7 = Arrays.asList(1, 2, 3, 4, 5);
        boolean anyEven = numbers7.stream().anyMatch(n -> n % 2 == 0); // Result: true
        System.out.println("anyEven ::"+anyEven);
        boolean allEven = numbers7.stream().allMatch(n -> n % 2 == 0); // Result: false
        System.out.println("allEven ::"+allEven);
        boolean noneNegative = numbers7.stream().noneMatch(n -> n < 0); // Result: true
        System.out.println("noneNegative ::"+noneNegative);

       // findFirst() and findAny()
       // Finds elements in the stream.
        List<String> names8 = Arrays.asList("John", "Jane", "Adam");

        Optional<String> first = names.stream().findFirst(); // Result: Optional["John"]
        System.out.println("first ::"+first.get());
        Optional<String> any = names.parallelStream().findAny(); // Result: Any element from the stream
        System.out.println("any ::"+any.get());

    }
}
