package practice;

import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String dept;
    double salary;

    Employee(String name, String dept, double salary) {
        this.name = name; this.dept = dept; this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class PartitionEmployees {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 90000),
            new Employee("Bob", "HR", 50000),
            new Employee("Charlie", "IT", 70000),
            new Employee("David", "HR", 450000)
        );

        Map<Boolean, List<Employee>> highPaid = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.salary > 60000));

        System.out.println("High Paid: " + highPaid.get(true).size());
        System.out.println("Low Paid: " + highPaid.get(false).size());
        System.out.println("High Paid: " + highPaid.get(true));
        System.out.println("Low Paid: " + highPaid.get(false));
    }
}
