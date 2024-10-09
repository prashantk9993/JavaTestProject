package all;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortEmployee {

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Prashant", 30000));
        emp.add(new Employee("Ashwini", 30));
        emp.add(new Employee("Emp1", 5000));
        emp.add(new Employee("Emp2", 6000));
        emp.add(new Employee("emp4", 10000));

        System.out.println(emp);
        emp.stream().sorted((x,y)-> Integer.compare(x.getSalary(),y.getSalary())).limit(2).forEach(System.out::println);
    }

}

class Employee {

    private String name;
    private Integer salary;

    public Employee(String name,int salary){
        this.name=name;
        this.salary=salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}