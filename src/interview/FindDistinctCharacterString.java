package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDistinctCharacterString {

    public static void main(String[] args) {

        List<String> lst = Arrays.asList("aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah", "allessandra", "allianna",
                "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabelle", "annebelle");

        for (String str : lst){
          Map<Object,Long> map = Arrays.stream(str.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
            System.out.println(str+" "+map.size());
           // System.out.println(map.size());
          System.out.println();
        }
    }
}
