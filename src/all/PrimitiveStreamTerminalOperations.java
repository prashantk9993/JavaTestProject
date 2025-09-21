package all;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class PrimitiveStreamTerminalOperations {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        IntStream is = IntStream.of(arr);
        int sum = is.sum();
        System.out.println(sum);

        IntStream is2 = IntStream.of(arr);
        OptionalInt min = is2.min();
        System.out.println(min.getAsInt());

        IntStream is3 = IntStream.of(arr);
        OptionalInt max = is3.max();
        System.out.println(max.getAsInt());

        IntStream is4 = IntStream.of(arr);
        OptionalDouble average = is4.average();
        System.out.println(average.getAsDouble());



    }
}
