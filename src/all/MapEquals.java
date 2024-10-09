package all;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MapEquals {

    public static void main(String[] args) {
        Set<Employee3> set = new HashSet<>();

        Employee3 e1=new Employee3(1,"test");
        Employee3 e2=new Employee3(1,"test");
        Employee3 e3=new Employee3(2,"test");

        set.add(e1);
        set.add(e2);
        set.add(e3);

        System.out.println(set.size());
    }
}

class Employee3 {
    int id;
    String name;

    public Employee3(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee3)) return false;
        Employee3 employee3 = (Employee3) o;
        return id == employee3.id && name.equals(employee3.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
