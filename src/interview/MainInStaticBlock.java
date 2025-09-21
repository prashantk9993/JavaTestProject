package interview;

public abstract class MainInStaticBlock {

    static {
        System.out.println("Static block Hello world.....");
        // compile time issue
       /* public static void main(String[] args) {
            System.out.println("Hello world.....");
        }*/
    }

}
