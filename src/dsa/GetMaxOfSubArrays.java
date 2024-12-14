package dsa;

import java.util.Arrays;

public class GetMaxOfSubArrays {

    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] array = new int[]{1,2,3,4,5};

        for (int i =0; i < array.length ; i++){
         //   System.out.println(array[i]);
        }

        for (int i =0; i < 3 ; i++){
             int[] res = Arrays.copyOfRange(array,i,i+2);
             for (int j = 0 ; j < 3 ; j++) {
                 System.out.print(res[j] + "  ");
             }
        }

    }
}
