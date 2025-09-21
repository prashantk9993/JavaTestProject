package temp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SynechronInterview {

    public static void main(String[] args) {
        String input = "ABA";

        List<String> listRes = new ArrayList<>();

        System.out.println("Substrings >");
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                listRes.add(input.substring(i, j));
                //System.out.println(input.substring(i, j));
            }
        }

        System.out.println("List >"+listRes);

      /*Map<String[],Long> mapRes = listRes.stream().map(x-> x.split(""))
              .peek(x->System.out.println("peek1:::"+Arrays.toString(x)))
              .distinct().collect(Collectors.groupingBy(x->x, Collectors.counting())
        );
      mapRes.forEach((x,y)-> System.out.println(x+"==="+y));*/

        Map<List<String>,Long> mapRes = listRes.stream().map(x-> List.of(x.split("")))
               // .peek(x->System.out.println("peek1:::"+x))
                .distinct()
               // .peek(x->System.out.println("Dist peek1:::"+x))
                .collect(Collectors.groupingBy(x->x, Collectors.counting())
                );
        mapRes.forEach((x,y)-> System.out.println(x+"==="+y));
    }



   /* public static void main(String[] args) {

        String[] input  = {"A", "B", "A", "AB", "BA", "ABA"};

        Map<String,Long> res = Arrays.stream(input).collect(Collectors.collectingAndThen()));

        res.forEach((x,y)-> System.out.println(x+" == "+y));

    }*/
}

/*

Example:

Input String: ABA

Output: 8

Explanation:

Substrings> A, B, A, AB, BA, ABA

A - 1

B - 1

A - 1

AB - 2

BA - 2

ABA - 1 (since A is repeated, A is ignored and only B is considered here)



        1+1+1+2+2+1 = 8 (final output)*/