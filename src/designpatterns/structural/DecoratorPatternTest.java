package designpatterns.structural;


/*
* The Decorator pattern is a structural design pattern that allows you to dynamically
* add behavior to individual objects at runtime, without modifying other instances of the same class.
* It follows the Open/Closed Principle: objects are open for extension but closed for modification
 */

public class DecoratorPatternTest {

	public static void main(String[] args) {
		Car sportsCar = new SportsCar(new BasicCar());
		sportsCar.assemble();
		System.out.println("\n*****");
		
		Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
		sportsLuxuryCar.assemble();
	}

}