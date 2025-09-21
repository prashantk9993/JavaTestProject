package all;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberTest {

    public static void main(String[] args) {

        PrimeNumberTest obj = new PrimeNumberTest();
        obj.getAllPrimeNumberFromZeroToN(100);
    }

    int[] getAllPrimeNumberFromZeroToN(int n){

        List<Integer> res = new ArrayList<>();



        for (int i=1 ; i < n ; i++){
            int count = 0;
            if (i == 1){
                System.out.println(i);
            }
            if (i ==2 ){
                System.out.println(i);
            }
            if( i%2 == 0 ){
                count ++;
            }
            if(count<1){
                System.out.println(i);
            }
        }

        return null;
    }
}
