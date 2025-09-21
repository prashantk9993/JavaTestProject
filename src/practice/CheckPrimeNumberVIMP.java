package practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CheckPrimeNumberVIMP {
    public static void main(String[] args) {

        System.out.println(isPrime(2));

        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(CheckPrimeNumberVIMP::isPrime));

        System.out.println(partitioned.get(true));
        System.out.println(partitioned.get(false));
    }

    public static boolean isPrime(int num){
        if(num<=1){
            return false;
        }
        for (int i = 2; i < num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
