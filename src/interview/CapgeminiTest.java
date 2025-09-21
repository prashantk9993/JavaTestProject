package interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CapgeminiTest {
    public static void main(String[] args) {
        String input ="java is good language";
       /* Map<String,Long> result = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(x-> x, Collectors.counting()));

        result.entrySet().stream().filter(x-> x.getValue()== 1L)
                .forEach(x-> System.out.println(x.getKey()+" -- "+x.getValue()));*/

        Map<String,Long> result2 = Arrays.stream(input.split(""))
                .collect(Collectors.groupingBy(x-> x, LinkedHashMap::new ,Collectors.counting()));

        String re = result2.entrySet().stream().filter(x-> x.getValue()== 1L).map(Map.Entry::getKey).findFirst().orElse(null);
        System.out.println("Output ======"+re);
    }
}
