package all;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupStringByLength {
    public static void main(String[] args) {

        //================= Group by length of strings =================
        System.out.println( " ================================== ");
        List<String> words = Arrays.asList("apple", "bat", "car", "ball", "dog", "elephant");
       Map<Integer,List<String>> res = words.stream().collect(Collectors.groupingBy(String::length));
       res.forEach((a,b) -> System.out.println(a+" == "+b));

       //================== Group by odd even numbers ================
        System.out.println( " ================================== ");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6,7);

        Map<String,List<Integer>> res2 = numbers.stream().collect(Collectors.groupingBy(
                n-> n%2==0 ? "Even" : "Odd"
        ));
        res2.forEach((a,b) -> System.out.println(a+" == "+b));

        //================== Group with downstream ================
        System.out.println( " ================================== ");

        Map<String, Long> res3 = numbers.stream().collect(Collectors.groupingBy(
                n-> n%2==0 ? "Even" : "Odd"
                ,
                Collectors.counting()
        ));

        res3.forEach((a,b) -> System.out.println(a+" == "+b));

    }
}
