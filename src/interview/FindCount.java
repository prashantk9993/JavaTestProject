package interview;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class FindCount {
    public static void main(String[] args) {

        String s = "this is a test this test is only a test sentence for the test";

        String[] arr = s.split(" ");

      //  Arrays.stream(s.split(" ")).sorted().collect(Collectors.groupingBy(x->x, Collectors.counting())).forEach((x,y)-> System.out.println(x + " == "+ y));


      //  Map<Object,Long> map = Arrays.stream(s.split(" ")).sorted().collect(Collectors.groupingBy(x->x, Collectors.counting()));

      //  Map<Object,Long> tMap = new TreeMap<>(map);

      //  tMap.forEach((x,y)-> System.out.println(x+"  "+y));

        Map<String,Integer> result = new LinkedHashMap<>();

        for (int i = 0 ; i < arr.length;i++){

            if(result.containsKey(arr[i])){

               int count =  result.get(arr[i]);

                result.put(arr[i],count+1);

            }else {
                result.put(arr[i],1);
            }
        }

        System.out.println("Final result;;;;;;;;;;;;;");

        result.forEach((x,y)-> System.out.println(x+"  "+y));

    }
}
