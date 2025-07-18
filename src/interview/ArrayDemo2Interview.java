package interview;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

public class ArrayDemo2Interview {

    public static void main(String[] args) {

        Integer[] array1 = {1,2,3,4,5,6,7,8,9};
        Arrays.sort(array1 , Collections.reverseOrder());
        Arrays.stream(array1).forEach(x->System.out.println(x));

        for (int i = 0 ; i < array1.length ; i++){
            Optional<Integer> out1 = Arrays.stream(array1).sorted((x, y)-> y-x).findFirst();
            int max = out1.get();
            if(max == array1[i]){
                array1[i] = max/2;
            }
        }
        System.out.println("Result==========");
        Arrays.stream(array1).forEach(x->System.out.println(x));

    }
}
