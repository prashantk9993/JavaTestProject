package interview.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingExecutorFramework {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 1. Create a thread pool with a fixed number of threads
        ExecutorService executorService  = Executors.newFixedThreadPool(2);

        // 2. Submit tasks for execution
        // Submit a Runnable (no return value)

        //submit has overloaded of Runnable as well as Callable
        //executorService.submit( () -> System.out.println("Runnable Thread"+Thread.currentThread().getName()));

        // execute only takes runnable
        executorService.execute( () -> System.out.println("Runnable Thread"+Thread.currentThread().getName()));

        // Submit a Callable (returns a Future)
        Future<String> future = executorService.submit(() -> {
            System.out.println("Runnable Thread"+Thread.currentThread().getName());
            return "Callable Returned thread value";
        });

        // 3. Main thread can get the result from the Future
        System.out.println(future.get());

        // 4. Important: Shut down the executor service
        executorService.shutdown();

    }
}
