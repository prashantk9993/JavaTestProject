package practice;

import java.util.function.Function;

public class GenericMethodReference {
    public static <T> T identity(T value){
    return value;
    }

    public static void main(String[] args) {

        // method ref to generic method
        Function<String, String> stringIdentity = GenericMethodReference::identity;
        System.out.println(stringIdentity.apply("Hello.."));

        // method ref to generic method
        Function<Integer, Integer> intIdentity = GenericMethodReference::identity;
        System.out.println(intIdentity.apply(50));
    }
}
