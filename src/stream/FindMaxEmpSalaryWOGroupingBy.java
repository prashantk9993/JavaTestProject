package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindMaxEmpSalaryWOGroupingBy {

    public static void main(String[] args) {

        List<Employee2> employees = Arrays.asList(
                new Employee2(1, "John", "IT", 75000),
                new Employee2(2, "Jane", "HR", 65000),
                new Employee2(3, "Mike", "IT", 80000),
                new Employee2(4, "Sarah", "HR", 70000),
                new Employee2(5, "Tom", "Finance", 99999000),
                new Employee2(6, "Lisa", "IT", 78000),
                new Employee2(7, "Bob", "Finance", 850000),
                new Employee2(8, "Alice", "HR", 7200000)
        );
        Optional<Employee2> emp  = employees.stream().collect(Collectors
                .maxBy((x,y) -> x.salary()-y.salary()));
        System.out.println(emp.get()); // 99999000
        System.out.println(emp.get().salary()); // 99999000
    }
}

record Employee2(int id, String name, String dept, int salary){}