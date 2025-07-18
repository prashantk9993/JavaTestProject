package interview;

import java.util.*;
import java.util.stream.Collectors;

public class FindDistinctCharacterString2 {

    public static void main(String[] args) {

        List<String> lst = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah", "allessandra", "allianna",
                "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle", "annebelle");


        Collections.sort(lst);
        System.out.println(lst);

       // Map<Object,Long> res =  lst.stream().collect(Collectors.groupingBy(x->x,Collectors.counting()));
       // res.entrySet().stream().forEach(x-> System.out.println(x.getKey()+" "+x.getValue()));

        for (String s : lst){

           System.out.println(Arrays.stream(s.split("")).sorted().collect(Collectors.toCollection(ArrayList::new)).toString());
        }
    }
}
