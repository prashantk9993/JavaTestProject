package interview.adaptor;

public class TestAdaptor {

    public static void main(String[] args) {

        Iphone6SCharger iphone6s = new Iphone6SCharger(new Iphone5STo6SAdapter());
        iphone6s.onCharge();

    }
}
