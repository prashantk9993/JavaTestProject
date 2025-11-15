package all;

public class TestBreak {
    public static void main(String[] args) {

        int i = 0;
        for (; i < 5; i++) {
            if (i == 3) break;
        }
        System.out.println(i);
    }
}