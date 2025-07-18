package practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

// Submit tasks
        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));
        executor.submit(() -> System.out.println("Task 3"));
        executor.submit(() -> System.out.println("Task 4"));
        executor.submit(() -> System.out.println("Task 5"));
        executor.submit(() -> System.out.println("Task 6"));

        executor.shutdown();
    }
}
