package interview.factory;

public class FactoryDemo {

    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        factory.getShape("CIRCLE").draw();
        factory.getShape("SQUARE").draw();
        factory.getShape("RECTANGLE").draw();
    }
}
