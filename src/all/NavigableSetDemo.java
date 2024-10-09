package all;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetDemo {
    public static void main(String[] args) {
        NavigableSet ns = new TreeSet<>();
        ns.add("R");
        ns.add("F");
        ns.add("A");
        ns.add("C");
        ns.add("B");
        ns.add("X");
        System.out.println("1:::"+ns);
        System.out.println("2:::"+ns.ceiling("D"));
        System.out.println("3:::"+ns.descendingSet());
        System.out.println("4:::"+ns.floor("D"));
        System.out.println("5:::"+ns.higher("F"));
        System.out.println("6::::"+ns.lower("F"));
        System.out.println("7::::"+ns.pollFirst());
        System.out.println("8::::"+ns.pollLast());
    }
}
