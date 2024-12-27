package interview;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class CountCharOutsideNumeric {


    public static void main(String[] args) {
        String s2 = "asedr1aaaw2aff3aa";
        String[] arr = s2.split("[0-9]");

        String result = new String();
       /* String[] resArray = {arr[0],arr[arr.length-1]};
        for (int i = 0 ; i < resArray.length;i++){
            result= result+resArray[i];
        }*/

        result=arr[0];
        result=result+arr[arr.length-1];
        System.out.println(result);

      Map<Object,Long> resMap = Arrays.stream(result.split("")).collect(Collectors.groupingBy(x->x,Collectors.counting()));
               //.entrySet().stream().filter(x->x.getKey().equalsIgnoreCase("a"));
        resMap.forEach((x,y)-> System.out.println(x+" "+y));

    }
}
