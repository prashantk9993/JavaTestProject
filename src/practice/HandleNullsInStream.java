package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HandleNullsInStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Khunte","Bhagwat",null,"Prashant");

        list.stream()
                .filter(Objects::nonNull)
                .filter(s->s.startsWith("P"))
                .forEach(System.out::println);
    }

}
