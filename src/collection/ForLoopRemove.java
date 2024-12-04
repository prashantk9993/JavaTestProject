package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForLoopRemove {
    public static void main(String[] args) {
        List<Integer> values = new ArrayList<>(); // Arrays.asList(1,2,3,4,5);
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        System.out.println(values);

        for (int i = 0;i<values.size();i++){
            if(values.get(i)==3){
                values.remove(3);
            }
        }
        System.out.println(values);
    }
}

/*
[1, 2, 3, 4, 5]
[1, 2, 3, 5]
*/
