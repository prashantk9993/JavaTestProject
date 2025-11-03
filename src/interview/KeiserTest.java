package interview;

import java.util.Arrays;

public class KeiserTest {

    public static void main(String []args) {
        Integer[] arr1 = {1,2,6,3,8,3};
        System.out.println(arr1);
           Arrays.stream(arr1).sorted((x,y)-> y-x).skip(1).limit(1).forEach(x-> System.out.println(x));
    }

}
