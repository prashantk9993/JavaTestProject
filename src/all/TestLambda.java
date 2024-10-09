package all;
public class TestLambda {
    static int id =10;
    public static void main(String[] args) {

        Lamb1 l1 = () -> System.out.println(id);
        l1.test1();

        Lamb1 l2 = () -> {
            Integer id2;
            id2=40;
            id2= id2*4;
            String str = new String("hjsdbfhjsd");
            str=str+"dfdfd";
            id=id+20;
            System.out.println(id);
            System.out.println(id2);
        };

        l2.test1();
    }
}

interface Lamb1{
    public void test1();
}