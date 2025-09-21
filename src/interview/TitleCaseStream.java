package interview;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TitleCaseStream {
    public static void main(String[] args) {
        String input = "convert the first letter of each word to uppercase";

        String result = Arrays.stream(input.split(" "))
            .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1))
            .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
