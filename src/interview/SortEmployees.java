package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortEmployees {

    public static void main(String[] args) {
        List<Employee9> lst = new ArrayList<>();
        lst.add(new Employee9(1,"Prashant"));
        lst.add(new Employee9(2,"Khunte"));
        lst.add(new Employee9(3,"xyz"));
        lst.add(new Employee9(4,"jhxfbghjd"));

        lst.stream().sorted((x,y)->x.getName().compareTo(y.getName())).forEach(x->System.out.println(x.getName()));
        lst.stream().sorted((x,y)->x.getName().compareTo(y.getName())).map(x->x.getName()).collect(Collectors.toList());

    }

}

class Employee9 {
    private int id;
    private String name;

    public Employee9(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee9{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
