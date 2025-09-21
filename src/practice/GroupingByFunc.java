package practice;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByFunc {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "apple" , "cherry", "date", "apple","apple" , "cherry");

       // Map<Integer,List<String>> groupByLength = words.stream()
         //       .collect(Collectors.groupingBy(String::length));

        Map<Integer,List<String>> groupByLength = words.stream()
                .distinct()
                .collect(Collectors.groupingBy(s-> s.length()));

        System.out.println(groupByLength);

    }
}
