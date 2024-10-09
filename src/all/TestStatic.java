package all;

public class TestStatic {
    public static void main(String[] args) {
        Test1 obj = new Test1();
        System.out.println(obj.s); // using object
        System.out.println(Test1.s); // using class name
    }
}

class Test1{
    public static  int s = 10;
}