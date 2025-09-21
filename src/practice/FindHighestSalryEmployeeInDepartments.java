package practice;

import temp1.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindHighestSalryEmployeeInDepartments {

    public static void main(String[] args) {

        List<Employee> employees = List.of(new temp1.Employee[]{
                new temp1.Employee("abc", "IT", 25000),
                new temp1.Employee("aaa", "IT", 67000),
                new temp1.Employee("bbbb", "ACCOUNT", 35000),
                new temp1.Employee("rrrr", "ADMIN", 25000),
                new temp1.Employee("hhhh", "ACCOUNT", 156000),
        });

        //------------------------------------------------------------------------------
        //1. using Collectors.groupingBy with Collectors.maxBy
        System.out.println("======using Collectors.groupingBy with Collectors.maxBy=====");
        Map<String, Employee> result1 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment, // Function
                        Collectors.collectingAndThen(   // Collector downstream
                                Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
                                Optional::get)
                ));
        result1.forEach((x,y)-> System.out.println(x+" == "+y));

        //------------------------------------------------------------------------------
        //2. using Collectors.toMap with Merge function
        System.out.println("======using Collectors.toMap with Merge function=====");
        Map<String,Employee> result2 = employees.stream()
                .collect(Collectors.toMap(
                        Employee::getDepartment,
                        Function.identity(), // since we need full employee object as value in map => Returns a function that always returns its input argument.
                        (e1,e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2
                ));
        result2.forEach((x,y)-> System.out.println(x+" == "+y));
        //------------------------------------------------------------------------------
        //3. Using Collectors.teeing
        System.out.println("====== Using Collectors.teeing =====");
        Map<String, Employee> result3 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.teeing(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Collectors.minBy(Comparator.comparingDouble(Employee::getSalary)),
                                (max, min) -> max.orElse(null)
                        )
                ));

        result3.forEach((x,y)-> System.out.println(x+" == "+y));
    }
}
