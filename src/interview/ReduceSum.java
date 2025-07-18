package interview;

import java.util.Arrays;
import java.util.List;

public class ReduceSum {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 5, 7);

        int sum = numbers.stream()
                         .reduce(0, (a, b) -> a + b);  // identity = 0

        System.out.println("Sum: " + sum);  // Output: 15
    }
}
