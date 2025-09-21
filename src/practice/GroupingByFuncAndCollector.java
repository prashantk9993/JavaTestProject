package practice;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByFuncAndCollector {
    public static void main(String[] args) {

        List<String> words = List.of("apple", "banana", "apple" , "cherry", "date", "apple","apple" , "cherry");

        Map<String,Long> groupByLength = words.stream()
               .collect(Collectors.groupingBy(s->s , Collectors.counting()));

        // here groupingBy(Function, Collector)
        // Function is String -> String  , input string and output string

        System.out.println(groupByLength);
        System.out.println("==========================");

        // concat all strings in list and count per char

       // Arrays.stream(words.stream().collect(Collectors.joining()).split("")).peek(s->System.out.println(s));

        Map<String,Long> res = Arrays.stream(words.stream().collect(Collectors.joining()).split(""))
                .collect(Collectors.groupingBy(s->s,Collectors.counting()));
        System.out.println(res);

        System.out.println("==========================");

        // try for ordered

        LinkedHashMap<String,Long> res2 = Arrays.stream(words.stream().collect(Collectors.joining()).split(""))
                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new ,Collectors.counting()));
        System.out.println(res2);

        // find third char count

        Long count  = Arrays.stream(words.stream().collect(Collectors.joining()).split(""))
                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new ,Collectors.counting()))
                .values().stream().skip(2).findFirst().get();
        System.out.println(count);


        // Debugging all steps

        Long count2  = Arrays.stream(words.stream().collect(Collectors.joining()).split(""))
                .peek(s-> System.out.println(" Converting to Arrays::"+s))
                .collect(Collectors.groupingBy(s->s, LinkedHashMap::new ,Collectors.counting()))
                .values().stream()
                .peek(s-> System.out.println(" Converting to Map Values::"+s)).skip(2)
                .peek(s-> System.out.println(" After Skipping 2::"+s))
                .findFirst().get();
        System.out.println(count2);



    }
}

/*
        {date=1, banana=1, cherry=2, apple=4}
        ==========================
        {p=8, a=8, r=4, b=1, c=2, t=1, d=1, e=7, h=2, y=2, l=4, n=2}
        ==========================
        {a=8, p=8, l=4, e=7, b=1, n=2, c=2, h=2, r=4, y=2, d=1, t=1}

 */