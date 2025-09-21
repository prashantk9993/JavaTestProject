package all;

import java.util.stream.Stream;

public class StreamNullValue {
    public static void main(String[] args) {
        Stream.of("abc",null,"xyz").forEach(System.out::println);
        Stream.of(null).forEach(System.out::print);// NPE
    }
}
