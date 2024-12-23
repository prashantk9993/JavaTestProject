package interview.adaptor;

public class Iphone6SCharger implements IPhone{

    Charger iphonr5STo6SCharger;

    public Iphone6SCharger(Charger  iphonr5STo6SCharger){
    this.iphonr5STo6SCharger = iphonr5STo6SCharger;
    }

    @Override
    public void onCharge() {
        iphonr5STo6SCharger.charge();
    }
}
