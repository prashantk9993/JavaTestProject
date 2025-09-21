package practice;

import java.util.List;

public class TerminalCountOperation {
    public static void main(String[] args) {
        List<String> lst = List.of("Prashant","Khunte","Bhagwat");


        long count = lst.stream().count();

        System.out.println(count);

        long count1 = lst.stream().filter(x->x.contains("a")).count();

        System.out.println(count1);

    }
}
