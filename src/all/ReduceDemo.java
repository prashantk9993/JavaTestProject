package all;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 45, 7, 8, 9, 10);

        int sum = nums.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);

        Optional<Integer> addition = nums.stream().reduce(Integer::sum);
        System.out.println("sum is::"+addition.get());

        Optional<Integer> max = nums.stream().reduce(Integer::max);
        System.out.println("Max is::"+max.get());

        Optional<Integer> min = nums.stream().reduce(Integer::min);
        System.out.println("Min is::"+min.get());
    }
}
