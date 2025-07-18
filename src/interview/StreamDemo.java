package interview;

import java.util.ArrayList;
import java.util.List;

public class StreamDemo {

    public static void main(String[] args) {
        List<Employee> emp = new ArrayList<>();
        emp.add(new Employee("Prashant",25,5000000));
        emp.add(new Employee("Khunte",31,70000));
        emp.add(new Employee("Ash",28,785873485));

        System.out.println(emp);

        emp.stream().filter(x-> {
            if(x.getSalary()>50000 && x.getAge()< 30){
                return true;
            } return false;
        }).forEach(x->System.out.println(x.getName()));
    }

}

class Employee {
    private String name;
    private int age;
    private int salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee(String name, int age, int salary) {
        this.name=name;
        this.age=age;
        this.salary=salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}