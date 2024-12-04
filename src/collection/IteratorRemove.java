package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorRemove{
    public static void main(String[] args) {

        List<Integer> values = new ArrayList<>(); // Arrays.asList(1,2,3,4,5);
        values.add(1);
        values.add(2);
        values.add(3);
        values.add(4);
        values.add(5);
        System.out.println(values);
        Iterator<Integer> itr = values.iterator();
        while(itr.hasNext()){
            int val = itr.next();
          //  System.out.println(val);
            if(val==3){
                itr.remove();
            }
        }

        System.out.println("Values 3 removed using iterator :::::"+values);

        for (Integer inte: values) {
            if(inte==4){
                values.remove(inte);
            }
        }
        System.out.println("Values 4 removed using foreach :::::"+values);
    }
}

/* output
[1, 2, 3, 4, 5]
Values 3 removed using iterator :::::[1, 2, 4, 5]
Values 4 removed using foreach :::::[1, 2, 5]

 ------------------------

// List<Integer> values2 =   Arrays.asList(1,2,3,4,5);
The remove method of the Iterator interface is an optional operation.
It is not supported by iterators on unmodifiable collections, or iterators on lists constructed by the Arrays.
asList method. Invoking remove on such an iterator will lead to an UnsupportedOperationException .
*/
