package all;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            System.out.println("Try");
            throw new RuntimeException();
        } catch (Exception e) {
            System.out.println("Catch");
            return;
        } finally {
            System.out.println("Finally");
        }
    }
}