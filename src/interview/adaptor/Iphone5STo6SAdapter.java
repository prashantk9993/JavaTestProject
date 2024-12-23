package interview.adaptor;

public class Iphone5STo6SAdapter implements Charger{

    Iphone5SCharger iphone5Scharger;

    public Iphone5STo6SAdapter(){
        iphone5Scharger = new Iphone5SCharger();
    }

    @Override
    public void charge() {
        // We are charging iphone 6s with iphone 5s charger.
        iphone5Scharger.charge();
    }
}
