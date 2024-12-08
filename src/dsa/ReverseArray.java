package dsa;

import java.util.Arrays;

public class ReverseArray {

    // doing myself
    public static void main(String[] args) {
        int[] iArray = new int[] {101,102,103,104,105};

        System.out.println("Original int array : " + Arrays.toString(iArray) );

        int[] result = new int[iArray.length];

        for (int i = 0; i< iArray.length;i++){
            for (int j = ((iArray.length-1) - i );j>=0 ; j --){
                result[i] = iArray[j];
                break;
            }
        }

        System.out.println("Original int array : " + Arrays.toString(result) );
    }
}
