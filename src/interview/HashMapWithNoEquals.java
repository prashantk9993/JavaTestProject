package interview;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapWithNoEquals {

    public static void main(String[] args) {

        Map<Emplyee9,String> res = new HashMap<>();
        Emplyee9 emp1 = new Emplyee9(1,"Prashant");
        Emplyee9 emp2 = new Emplyee9(1,"Prashant");
        Emplyee9 emp3 = new Emplyee9(1,"Prashant");

        res.put(emp1, "Test1");
        res.put(emp2, "Test2");
        res.put(emp3, "Test3");

        System.out.println(res.size());
        System.out.println(res.get(emp2)); // If equal is not override it will return last entry

      /*  output
         3
        Test2*/
    }
}

class Emplyee9{

    private int id;
    private String name;

    public Emplyee9(int id, String name) {
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

    /*@Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Emplyee9 emplyee6 = (Emplyee9) o;
        return id == emplyee6.id && Objects.equals(name, emplyee6.name);
    }*/

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public String toString() {
        return "Emplyee9{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}