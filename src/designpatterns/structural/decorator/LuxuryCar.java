package designpatterns.structural.decorator;

//4. Concrete Decorator
public class LuxuryCar extends CarDecorator {

	public LuxuryCar(Car c) {
		super(c);
	}
	
	@Override
	public void assemble(){
		super.assemble();
		System.out.print(" Assembling Luxury Car.");
	}
}