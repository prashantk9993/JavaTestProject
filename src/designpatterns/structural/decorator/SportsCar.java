package designpatterns.structural.decorator;

//4. Concrete Decorator
public class SportsCar extends CarDecorator {

    public SportsCar(Car car) {
        super(car);
    }

    // Method overriding
    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Assembling Sports Car...");
    }
}
