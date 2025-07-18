package practice;

import java.util.concurrent.*;

public class ExecutorServiceFutureTest {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<?> future = executor.submit(() -> {
            // Long-running task
          //  Thread.sleep(5000); // Simulate work
            Thread.sleep(1000); // Simulate work
            return "Result";
        });

        try {
            // Wait for a maximum of 2 seconds
            String result = (String) future.get(2, TimeUnit.SECONDS);
            System.out.println("Task completed: " + result);
        } catch (TimeoutException e) {
            // Task timed out
            System.out.println("Task timed out!");
            future.cancel(true); // Interrupt the task if running
        } catch (Exception e) {
            // Handle other exceptions
        } finally {
            executor.shutdown();
        }
    }
}
