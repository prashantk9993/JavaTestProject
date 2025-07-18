package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConncurrentModiExceptionIteratorRemoveUsingList {
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
            if(val==3){
               // values.remove(val);
              //  values.add(10); -- exception occured when trying to add also
                itr.remove();
            }
        }
        System.out.println("Values 3 removed using iterator :::::"+values);
    }
}

/* output  -- Concurrent modification exception occures only when, if iterate and removed using list remove method
[1, 2, 3, 4, 5]
Exception in thread "main" java.util.ConcurrentModificationException
	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
	at collection.IteratorRemoveUsingList.main(IteratorRemoveUsingList.java:19)

*/
