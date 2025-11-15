package all;

public class TestPlusPlus {
    public static void main(String[] args) {
        int x = 5;
        int y = x++;
        int z = ++x;
        System.out.println(x +"=="+ y +"=="+ z);
        System.out.println(x + y + z);
    }
}