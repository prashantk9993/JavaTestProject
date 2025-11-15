package all;

import java.util.ArrayList;
import java.util.List;

public class TestListRemove {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");

        //ConcurrentModificationException
        for (String s : list) {
            if ("B".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list);

       /*  o/p = [A]

       for (int i = 0 ; i < list.size() ;i++){
            if (list.get(i).equals("B")) {
                list.remove(list.get(i));
            }
        }
        System.out.println(list);*/


    }
}