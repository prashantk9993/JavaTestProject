package all;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    public static void main(String[] args) {
        SortedSet<String> s = new TreeSet<>();
        s.add("V");
        s.add("D");
        s.add("G");
        s.add("A");
        s.add("I");

        System.out.println(s);
        System.out.println(s.first());
        System.out.println(s.last());
        System.out.println(s.headSet("G"));
        System.out.println(s.tailSet("G"));

    }
}
