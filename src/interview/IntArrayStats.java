package interview;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class IntArrayStats {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10,20,30,40,100,46,32,6);

        IntSummaryStatistics stats = numbers.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Sum is :"+stats.getSum());
        System.out.println("Average is :"+stats.getAverage());
        System.out.println("Min is :"+stats.getMin());
        System.out.println("Max is :"+stats.getMax());
        System.out.println("Count is :"+stats.getCount());
    }
}
