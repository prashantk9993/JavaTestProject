package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamPitfalls {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        stream.forEach(System.out::println);  // Terminal operation
        stream.count();  // IllegalStateException: stream has already been operated upon or closed

        Stream.generate(() -> "infinite").forEach(System.out::println);  // Runs forever
        Stream.generate(() -> "infinite").limit(10).forEach(System.out::println);  // Runs 10

        //list.stream().map(Object::toString).collect(...);  // NPE if list contains nulls

        list.stream().map(String::toUpperCase);  // Nothing happens - missing terminal op
    }
}
