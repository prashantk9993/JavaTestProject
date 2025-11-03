package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CACITest {
    public static void main(String[] args) {

        List<Employee4> lst =new ArrayList<>();
        lst.add(new Employee4("1","Prashant", List.of(123,456)));
        lst.add(new Employee4("2","Khunte", List.of(3464564)));
        lst.add(new Employee4("3","ASHWINI", List.of(5465,789789,56767)));

        List<Integer> phones  =
                lst.stream().flatMap(e -> e.getPhone().stream()).collect(Collectors.toList());

        for(Integer i : phones){
            System.out.println(i);
        }

        Map<String, List<Integer>> res = phones.stream()
                .collect(Collectors.teeing(
                        Collectors.filtering(n -> n % 2 == 0, Collectors.toList()),
                        Collectors.filtering(n -> n % 2 != 0, Collectors.toList()),
                        (evens, odds) -> Map.of("Even", evens, "Odd", odds)
                ));

        res.forEach((e,f) -> System.out.println(e + " "+ f));
    }
}


class Employee4 {

   String  id;
    String name;
 List<Integer> phone;

    public Employee4(String id, String name, List<Integer> phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getPhone() {
        return phone;
    }

    public void setPhone(List<Integer> phone) {
        this.phone = phone;
    }
}