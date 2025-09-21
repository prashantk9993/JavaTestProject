package interview;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamVSIntStream {

    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

        //Create Stream
        Stream s1 = Stream.of(arr);
        System.out.println(s1.count()); // 1 , since Stream support wrappers not primitives

        // Create IntStream
        IntStream s2 = IntStream.of(arr);
        System.out.println(s2.count()); //5

        //==============Wrapper Integer============
        Integer[] arr2 = {1,2,3,4,5};

        //Create Stream
        Stream s3 = Stream.of(arr2);
        System.out.println(s3.count()); // 5 , since Stream support wrappers and given wrapper

        //  Create IntStream
        //  IntStream s4 = IntStream.of(arr2); // compilation error, since IntStream
    }
}
