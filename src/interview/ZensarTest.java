package interview;

import temp1.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class ZensarTest {

    public static void main(String[] args) {
        List<temp1.Employee> employees = List.of(new temp1.Employee[]{
                new temp1.Employee("abc", "IT", 25000),
                new temp1.Employee("aaa", "IT", 67000),
                new temp1.Employee("bbbb", "ACCOUNT", 35000),
                new temp1.Employee("rrrr", "ADMIN", 25000),
                new temp1.Employee("hhhh", "ACCOUNT", 156000),
        });
        //System.out.println(employees);
        Map<String, temp1.Employee> topEmployeesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        temp1.Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingInt(temp1.Employee::getSalary)),
                                Optional::get
                        )
                ));
        // Print the result
        topEmployeesByDept.forEach((dept, emp) ->
                System.out.println(dept + " -----> " + emp));
        Map<String, List<temp1.Employee>> res =  employees.stream().collect(Collectors.groupingBy(temp1.Employee::getDepartment));
        //Map<String, Employee> res2 = res.entrySet().stream().map(obj-> obj.getValue().stream().max(Comparator.comparingInt(Employee::getSalary)));

        //Map<String, Employee> res2 = res.entrySet().stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).findFirst();

    Map<String, temp1.Employee> res3 = employees.stream().collect(Collectors.groupingBy(
            temp1.Employee::getDepartment,
            Collectors.collectingAndThen ( Collectors.maxBy(Comparator.comparingInt(temp1.Employee::getSalary)) ,
            Optional::get
            )
    ));

        employees.stream().collect(Collectors.groupingBy(
                temp1.Employee::getDepartment,
                Collectors.collectingAndThen ( Collectors.maxBy(Comparator.comparingInt(temp1.Employee::getSalary)) ,
                        Optional::get
                )
        )).forEach((x,y)-> System.out.println(x+"============="+y));


       temp1.Employee e = employees.stream().collect(Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),
               Optional::get));
       System.out.println("Highest salary employee::::"+e);


    }
}
