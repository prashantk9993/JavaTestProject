package interview;

public class TestSingleton {

    public static void main(String[] args) {
        SingletonDoubleCheck obj1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck obj2 = SingletonDoubleCheck.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);

    }
}
