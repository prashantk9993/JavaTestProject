package all;

import java.util.stream.Stream;

public class StreamGenerateIterate {

    public static void main(String[] args) {
        //Stream.iterate(0 , x-> x+1).forEach(System.out::println);
        Stream.iterate(0 , x-> x+1).limit(100).forEach(System.out::println);

       // Stream.generate(Math::random).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

    }
}
