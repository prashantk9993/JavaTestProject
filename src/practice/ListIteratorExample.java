package practice;

import java.util.*;

public class ListIteratorExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("A", "B", "C"));

        ListIterator<String> it = list.listIterator();

        // Forward traversal
        while (it.hasNext()) {
            System.out.println("Next: " + it.next());
        }

        // Backward traversal
        while (it.hasPrevious()) {
            System.out.println("Previous: " + it.previous());
        }

        // Modify elements
        while (it.hasNext()) {
            String value = it.next();
            if (value.equals("B")) {
                it.set("Beta");         // Modify "B" to "Beta"
                it.add("B+");           // Insert after Beta
            }
        }

        System.out.println("Modified List: " + list);
    }
}
