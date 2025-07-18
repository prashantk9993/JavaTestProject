package practice;

import org.w3c.dom.ls.LSException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MApVsFlatmap {
    public static void main(String[] args) {
        List<String> list = List.of("Hello","World","testString");

        List<Integer> length = list.stream().map(String::length).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(length);

        List<String> lst2 = List.of("a,b","c,d");
        List<String> lst3 = lst2.stream().flatMap(s-> Arrays.stream(s.split(","))).collect(Collectors.toList());
        System.out.println(lst2);
        System.out.println(lst2.get(0));
        System.out.println(lst3);
    }
}
