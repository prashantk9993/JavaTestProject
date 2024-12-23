package interview.adaptor;

public class Iphone5SCharger implements Charger{

    public Iphone5SCharger(){}

    @Override
    public void charge() {
        System.out.println("charging with 5s charger");
    }
}
