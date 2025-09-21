package all;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class SumAverageCount {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        int sum1 = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum is :::"+sum1);

        OptionalDouble avr = numbers.stream().mapToInt(Integer::intValue).average();
        System.out.println("Ave is :::"+avr.getAsDouble());

        long count = numbers.stream().count();
        System.out.println("Count is :::"+count);

        //========= vimp ==========

        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println("Stat Count is :::"+stats.getCount());
        System.out.println("Stat Sun is :::"+stats.getSum());
        System.out.println("Stat Average is :::"+stats.getAverage());
        System.out.println("Stat Max is :::"+stats.getMax());
        System.out.println("Stat Min is :::"+stats.getMin());
    }
}
