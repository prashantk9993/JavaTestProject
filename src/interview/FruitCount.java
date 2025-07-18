package interview;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitCount {
    public static void main(String[] args) {
        String[] fruits = {"Apple","Mango","Apple","Pineapple"};

      Map<String,Long> result =  Arrays.stream(fruits).collect(Collectors.groupingBy(fruit-> fruit,Collectors.counting()));

      result.forEach((x,y)->System.out.println(x+" "+y));



        Map<String, List<String>> result2 =  Arrays.stream(fruits).collect(Collectors.groupingBy(fruit-> fruit));

        System.out.println("=================");

        result2.forEach((x,y)->System.out.println(x+" "+y.size()));
    }
}
