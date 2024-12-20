package interview.singleton;

public class TestSingleton {

    public static void main(String[] args) {
        SingletonDoubleCheck obj1 = SingletonDoubleCheck.getInstance();
        SingletonDoubleCheck obj2 = SingletonDoubleCheck.getInstance();
        System.out.println(obj1);
        System.out.println(obj2);

        System.out.println("=====================");

        SingletonEager obj3 = SingletonEager.getInstance();
        SingletonEager obj4 = SingletonEager.getInstance();
        System.out.println(obj3);
        System.out.println(obj4);


        System.out.println("=====================");

        SingletonLazy obj5 = SingletonLazy.getInstance();
        SingletonLazy obj6 = SingletonLazy.getInstance();
        System.out.println(obj5);
        System.out.println(obj6);
    }
}
