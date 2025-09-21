package all;

import java.util.List;

public class PeekMisuse {
    public static void main(String[] args) {
        List<String> words = List.of("java","stream");

        List<String> upper = words.stream()
                .peek(s -> s.toUpperCase()) // does nothing!
                .toList();
        System.out.println(upper); // [java, stream]

        List<String> uppermap = words.stream()
                .map(s -> s.toUpperCase()) // does nothing!
                .toList();
        System.out.println(uppermap); // [java, stream]

    }
}
