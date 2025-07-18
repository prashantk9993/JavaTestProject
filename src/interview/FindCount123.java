package interview;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindCount123 {


        public static void main(String[] args) {
            String inp = "HelLO World";
            String[] arr = inp.split("");

            Map<String,Long> res =  Arrays.stream(arr).map(x->x.toLowerCase()).collect(Collectors.groupingBy(x->x, Collectors.counting()));

            res.forEach((x,y)-> System.out.println(x+"  -- "+y));
            System.out.println("Hello, World!");

    }
}
