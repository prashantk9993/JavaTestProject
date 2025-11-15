package all;

public class TestIntegerEquals {
    public static void main(String[] args) {
        Integer i1 = 127;
        Integer i2 = 127;
        Integer i3 = 128;
        Integer i4 = 128;

        Integer i5 = 5;
        Integer i6 = 5;
        
        System.out.print((i1 == i2) + " ");
        System.out.print((i3 == i4)+ " ");
        System.out.print((i5 == i6)+ " ");


    }
}