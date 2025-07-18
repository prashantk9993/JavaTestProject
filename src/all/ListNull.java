package all;
import java.util.*;
import java.util.stream.Collectors;

public class ListNull {
    public static void main(String[] args) {


        List<String> numbers = Arrays.asList("A","C","A","D","A","T");//new ArrayList<>();


        numbers.stream().filter(i -> Collections.frequency(numbers, i) >1)
                .forEach(System.out::println);

         numbers.stream().collect(Collectors.groupingBy(ch->ch , Collectors.counting()));

         numbers.stream().collect(Collectors.groupingBy(ch->ch , Collectors.counting())).forEach((x,y)->System.out.println(x+" "+y));
         numbers.stream().collect(Collectors.groupingBy(ch->ch , Collectors.counting())).forEach((x,y)->System.out.println(x+" "+y));
    }
}
