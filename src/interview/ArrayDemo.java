package interview;

import java.util.Arrays;
import java.util.Optional;

public class ArrayDemo {

    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8,9,10};

        //{10,2,3,4,5,6,7,8,9,10};

        //1. 10
        //2. half lebghth of 10

     //  Integer[] array2 = new Integer[out1.get()/2];

      //  Arrays.stream(array).sorted((x,y)->x-y);

        Arrays.stream(array).forEach(x->System.out.println(x));

       for (int i = 0 ; i < array.length ; i++){

           Optional<Integer> out1 = Arrays.stream(array).sorted((x, y)-> y-x).findFirst();
           Optional<Integer> out12= Arrays.stream(array).sorted((x, y)-> y-x).findAny();
           System.out.println(out1.get());
           System.out.println(array[i]);
           if(out1.get() == array[i]){
               array[i] = out1.get()/2;
           }


       }



    }
}
