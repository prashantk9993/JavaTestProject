package stream;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

public class AverageSalaryExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", 50000),
            new Employee("Bob", 60000),
            new Employee("Charlie", 70000)
        );

        double averageSalary = employees.stream()
           .collect(Collectors.averagingDouble(Employee::getSalary));

        System.out.println("Average Salary: " + averageSalary);
        System.out.println("Average Salary: " + employees.stream().collect(Collectors.averagingDouble(Employee::getSalary)));
    }
}
