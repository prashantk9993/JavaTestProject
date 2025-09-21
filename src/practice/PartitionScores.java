package practice;

import java.util.*;
import java.util.stream.*;

public class PartitionScores {
    public static void main(String[] args) {
        List<Integer> scores = Arrays.asList(85, 40, 60, 75, 55, 90);

        Map<Boolean, Long> counts = scores.stream()
                .collect(Collectors.partitioningBy(s -> s >= 60, Collectors.counting()));

        System.out.println("Pass count: " + counts.get(true));
        System.out.println("Fail count: " + counts.get(false));
    }
}
