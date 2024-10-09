package all;
import java.awt.*;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService es  = Executors.newFixedThreadPool(3);

        Future<Integer> f1; // Feature interface of Integer
        Future<Double> f2;  // Feature interface of Double
        Future<Integer> f3; // Feature interface of Integer

        // Calling Submit on ExecutorService , since its  callable task
        System.out.println("Starting....");
        f1= es.submit(new Sum(10));
        f2= es.submit(new Hypot(3,4));
        f3= es.submit(new Factorial(5));

        try {
            // Get the result out of Future using .get()
            System.out.println("Sum is::::"+f1.get());
            System.out.println("Hypoteneous is::::"+f2.get());
            System.out.println("Factorial is::::"+f3.get());
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        catch (ExecutionException exc) {
            System.out.println(exc);
        }
        es.shutdown();
        System.out.println("Done");
    }
}

// IMP :: its implementing Callable and override call method that is returning Integer
class Sum implements Callable<Integer> {
    int stop ;
    Sum(int v) { stop = v; }

    // Call method having return type
    public Integer call() {
        int sum = 0;
        for(int i = 1; i <= stop; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    double side1, side2;
    Hypot(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }
    public Double call() {
        return Math.sqrt((side1*side1) + (side2*side2));
    }
}

class Factorial implements Callable<Integer> {
    int stop;
    Factorial(int v) { stop = v; }
    public Integer call() {
        int fact = 1;
        for(int i = 2; i <= stop; i++) {
            fact *= i;
        }
        return fact;
    }
}
