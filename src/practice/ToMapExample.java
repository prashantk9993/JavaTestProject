package practice;

import java.util.*;
import java.util.stream.Collectors;

public class ToMapExample {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "cherry");

        Map<Integer, String> lengthToFruit = fruits.stream()
                .collect(Collectors.toMap(
                        String::length, // key mapper (fruit length)
                        fruit -> fruit , // value mapper (fruit itself)
                        (f1, f2) -> f1 + ", " + f2 // merge function for duplicate keys
                ));

        System.out.println(lengthToFruit);
    }
}
