package all;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Stream s1 = Stream.of(arr);
        System.out.println("Stream.of count::"+s1.count());
        IntStream s2 = IntStream.of(arr);
        System.out.println("IntStream.of count::"+s2.count());

        //VIMP : output 5 since Stream support wrappers not premitives
        Integer[] arr3 = {1,2,3,4,5};
        Stream s3 = Stream.of(arr3);
        System.out.println("For Integer Stream.of count::"+s3.count());
    }
}

/*
O/P
Stream.of count::1
IntStream.of count::5
For Integer Stream.of count::5
*/
