package practice;

import java.util.stream.IntStream;

public class CheckPrimeNumber1 {
    public static void main(String[] args) {

        IntStream.range(1,100).filter(x-> checkPrime(x)).forEach(System.out::println);
      //  System.out.println(checkPrime(5));
    }

    public static boolean checkPrime(int num) {
        int count = 0 ;
        for (int i=2 ; i <= num ; i++){
            // if num is even then mod is 0 , and num%num is zero
            // i.e num = 4 then 2%4 = 0 && 4%4 == 0 , hence count = 2, so not prime
            if (num%i == 0){
                count++;
            }
        }
        return count == 1;
    }
}
