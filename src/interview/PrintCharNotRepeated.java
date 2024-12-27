package interview;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PrintCharNotRepeated {

    public static Map<String,Long> res4 = new HashMap<>();

    public static void main(String[] args) {
        String s = "assdssaead";

        Map<String, Long> res = Arrays.stream(s.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting()));

        res.entrySet().stream().filter(x -> x.getValue() == 1).forEach(x -> System.out.println("Result ::" + x.getKey()));
/*

      //------------
        String s2 = "asedr1aaaw2aff3aa";


       // s2.
        String[] arr = s2.split("[0-9]");

        System.out.println(arr.length);

        Map<String,Long> res2 = Arrays.stream(arr[0].split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));

        //  res2.entrySet().stream().filter(x->x.getValue()==1).forEach(x->System.out.println("Result ::"+x.getKey()));

       // res2.forEach((x,y)->System.out.println(x+" "+y));


        System.out.println("=======");
        Map<String,Long> res3 = Arrays.stream(arr[3].split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));

        //  res2.entrySet().stream().filter(x->x.getValue()==1).forEach(x->System.out.println("Result ::"+x.getKey()));

        //res3.forEach((x,y)->System.out.println(x+" "+y));

        res4.putAll(res2);


       // getCount(res2);
      //  getCount(res3);

        res4.forEach((x,y)->System.out.println(x+" Rsult "+y));
        res3.forEach((x,y)->System.out.println(x+" Rsult "+y));



        for (Map.Entry  entry : res3.entrySet()){
            if(res4.containsKey(entry.getKey())){
                System.out.println(entry.getValue());
                Long l1 = Long.getLong(entry.getValue().toString());
                System.out.println(res4.get(entry.getKey()));
                Long l2 = res4.get(entry.getKey());
                res4.put(entry.getKey().toString(), l1+l2);
            }
        }

    }
*/


   /* public static void getCount(Map<String,Long> map){


        for (Map.Entry  entry : map.entrySet()){

            if(res4.containsKey(entry.getKey())){
              Long count =   res4.get(entry.getKey());
              System.out.println(count);
              res4.put(entry.getKey().toString(),res4.get(entry.getKey())+count );
            }else {
               // res4.put(entry.getKey().toString(),Long.getLong(entry.getValue().toString()));
            }
        }

    }*/
    }
}
