package all;

import java.util.HashSet;
import java.util.List;

public class StreamDistinctDemo {
    public static void main(String[] args) {


        List<String> names = List.of("Alice", "Bob", "Alice", "Charlie");
        names.stream().distinct().forEach(System.out::println);

        List<String> distinctNames = names.stream()
                .filter(new HashSet<>()::add).toList();
        System.out.println(distinctNames);


        // use equals and hashcode in Person
   /*     List<Person> people = List.of(new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Alice", 25));

        List<Person> uniquePeople = people.stream()
                .distinct()
                .toList();*/

    }
}
