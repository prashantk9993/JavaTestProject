package designpatterns.structural.decorator;

//2. Component Implementation
public class BasicCar implements Car{

    @Override
    public void assemble() {
        System.out.println("Assembling basic car...");
    }
}
