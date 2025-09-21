package practice;

import java.util.function.Consumer;

public class MethodRefForGenericMathod {
    public static void main(String[] args) {

        //using lambda
        // why we use consumer , since method is accepting value
        Consumer<String> cons1 = (s) ->  Utils.<String>print(s);
        cons1.accept("Hello Prashant....");

        Consumer<Integer> cons2 = (s) ->  Utils.<Integer>print(s);
        cons2.accept(12345);

        //using MR
        Consumer<String> cons3 = Utils::print;
        cons3.accept("Prashant Khunte");

    }
}

class Utils {
    public static <T> void print(T item){
        System.out.println(item);
    }
}