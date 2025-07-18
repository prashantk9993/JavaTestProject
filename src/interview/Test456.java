package interview;

import java.util.Arrays;

public class Test456 {
    public static void main(String[] args) {
        String[] strArr = {"java", "abcd", "avaj", "aavj", "cdba"};

        //output
        //java, avaj, aavj
        //abcd, cdba

       for (int i = 0 ; i < strArr.length ; i++){
            String[] arr1 = strArr[i].split("");
             Arrays.sort(arr1);
            for (int j = i+1 ; j < strArr.length ; j++){
                String[] arr2 = strArr[j].split("");
                Arrays.sort(arr2);

                if(Arrays.equals(arr1,arr2)){
                    System.out.print( strArr[i]+" "+strArr[j]);
                } {

                }

            }
        }

        /*for (int i = 0 ; i < strArr.length ; i++) {
            Arrays.stream(strArr)
        }*/

    }
}
