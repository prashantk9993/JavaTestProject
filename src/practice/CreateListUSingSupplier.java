package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class CreateListUSingSupplier {
    public static void main(String[] args) {

        Supplier<List<String>> sup1 = () -> new ArrayList<>();

        List<String> lst1 = sup1.get();
        List<String> lst2 = sup1.get();

        lst1.add("a");
        lst2.add("a");

        System.out.println(lst1);
        System.out.println(lst2);

        ///  using MR
        Supplier<List<String>> sup2 = ArrayList::new;
        List<String> lst3 = sup2.get();
        List<String> lst4 = sup2.get();
        lst3.add("b");
        lst4.add("b");

        System.out.println(lst3);
        System.out.println(lst4);



    }
}
