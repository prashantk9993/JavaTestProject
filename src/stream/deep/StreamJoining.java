package stream.deep;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamJoining {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Adam");

        // 3 constructors of joining, 1. no param  2. delimiter  3. delimiter , prefix , suffix
        String joined = names.stream().collect(Collectors.joining());
        System.out.println(joined); //JohnJaneAdam

        String joined2 = names.stream().collect(Collectors.joining(", "));
        System.out.println(joined2); //John, Jane, Adam

        String joined3 = names.stream().collect(Collectors.joining(", ", "{", "}"));
        System.out.println(joined3); //{John, Jane, Adam}
    }
}
