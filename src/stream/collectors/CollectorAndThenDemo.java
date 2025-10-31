package stream.collectors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorAndThenDemo {

   //1. Run a collector (like toList, toSet, groupingBy, etc.)
   //2.  Then apply a finishing transformation on the collected result.

    public static void main(String[] args) {

        // 1: Make a List Unmodifiable
        List<String> list = Stream.of("A", "B", "C")
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        Collections::unmodifiableList
                ));
        System.out.println(list); // [A, B, C]
        // list.add("D"); // Throws UnsupportedOperationException

        //2: Count Elements After Collecting
        int count = Stream.of("apple", "banana", "orange")
                .collect(
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                List::size));
        System.out.println(count); // 3
        System.out.println(Stream.of("apple", "banana", "orange").count()); // 3
    }
}
