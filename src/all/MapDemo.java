package all;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MapDemo {

    public static void main(String[] args) {
        Set<Employee2> set = new TreeSet<>();
        Employee2 e1=new Employee2(1,"test");
        Employee2 e2=new Employee2(1,"test");
        Employee2 e3=new Employee2(2,"test");
        set.add(e1);
        set.add(e2);
        set.add(e3);
       System.out.println(set.size());
    }
}

class Employee2 implements Comparable<Employee2>{
    int id;
    String name;

    public Employee2(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Employee2 o) {
        return this.id-o.id;
    }
}