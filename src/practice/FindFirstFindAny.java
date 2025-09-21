package practice;

import java.util.stream.Stream;

public class FindFirstFindAny {
    public static void main(String[] args) {

        String firstElement = Stream.of("A","B","C","D").findFirst().get();
        String anyElement = Stream.of("t","A","B","C","D").findAny().get();

        System.out.println(firstElement);
        System.out.println(anyElement);

        Integer min = Stream.of(1,2,3,4,5).min(Integer::compare).get();
        Integer max = Stream.of(1,2,3,65,4,5).max(Integer::compare).get();
        System.out.println(min);
        System.out.println(max);
    }
}
