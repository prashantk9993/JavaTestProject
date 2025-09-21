package all;

import java.util.stream.IntStream;

public class PrimeNumberDemo {
    public static void main(String[] args) {

        IntStream.range(0,100).filter(x-> checkPrime(x)).forEach(System.out::println);
    }

    public static boolean checkPrime(int num){
        int count = 0;
        for(int i=2; i<=num; i++){
            if(num%i == 0){
                count++;
            }
        }
        return count == 1;
    }
}
