package all;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PeekDemo {
    public static void main(String[] args) {
       /*List<Integer> lst = Stream.iterate(0, x->x+1).limit(100)
               .skip(10)
               .peek(System.out::println)
               .sorted((a,b)-> (b-a))
               .peek(x-> System.out.println(x))
               .collect(Collectors.toList());
*/

        Integer sum   = Stream.iterate(0, x->x+1).limit(10)

                .reduce(0, Integer::sum);

        System.out.println(sum);

    }
}
