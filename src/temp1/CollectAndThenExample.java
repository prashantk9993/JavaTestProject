package temp1;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectAndThenExample {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee[]{
                new Employee("abc", "IT", 25000),
                new Employee("aaa", "IT", 67000),
                new Employee("bbbb", "ACCOUNT", 35000),
                new Employee("bbbb", "ACCOUNT", 35000),
                new Employee("rrrr", "ADMIN", 25000),
                new Employee("hhhh", "ACCOUNT", 156000),
                new Employee("hhhh", "ACCOUNT", 156000),
        });

        System.out.println("List ::::::"+employees.size());
        Set<Employee> set = employees.stream().collect(Collectors.collectingAndThen(
                Collectors.toSet(),
                Collections::unmodifiableSet
        ));

        System.out.println("Set ::::::"+set.size());


        Set<Employee> set2 = employees.stream().collect(Collectors.toSet());

    }
}
