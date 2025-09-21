package practice;

import java.util.*;
import java.util.stream.*;

public class PartitionPrimes {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(PartitionPrimes::isPrime));

        System.out.println("Primes: " + partitioned.get(true));
        System.out.println("Non-Primes: " + partitioned.get(false));
    }

    static boolean isPrime(int n) {
        return n > 1 && java.util.stream.IntStream.rangeClosed(2, (int)Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }
}
