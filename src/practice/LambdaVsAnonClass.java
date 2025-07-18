package practice;

public class LambdaVsAnonClass {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Hello I am Lambda");

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello I am Anonemous class");
            }
        };

        r.run();
        r1.run();
    }
}
