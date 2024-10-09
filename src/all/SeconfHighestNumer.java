package all;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeconfHighestNumer {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(23,5,87,323,56,76,34,23,32,3543,3543);

        list.stream().distinct().sorted((n1,n2)->n2.compareTo(n1)).skip(1).limit(1).forEach(System.out::println);

      //  list.stream().collect(Collectors.groupingBy(n->n)).entrySet().forEach(System.out::println);

      //  list.stream().collect(Collectors.groupingBy(n->n)).entrySet()..stream().sorted((n1,n2)->n2.compareTo(n1)).skip(1).limit(1);

    }
}
