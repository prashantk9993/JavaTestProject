package designpatterns.structural.decorator;

//3. Decorator

// implements Car, IS-A relationship
public class CarDecorator implements Car {

    //  HAS-A relationship
    protected Car car;

    public CarDecorator(Car car){
        this.car=car;
    }

    @Override
    public void assemble() {
        this.car.assemble();
    }
}
