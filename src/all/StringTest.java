package all;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.print((s1 == s2) + " ");
        System.out.print((s1 == s3) + " ");
        System.out.print((s3 == s4) + " ");
        System.out.print(s1.equals(s3)+ " ");
        System.out.print(s3.equals(s4)+ " ");
    }
}