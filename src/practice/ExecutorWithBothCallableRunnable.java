package practice;

import java.util.concurrent.*;

public class ExecutorWithBothCallableRunnable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(2);

        service.submit(() -> {
            System.out.println(Thread.currentThread().getName()+" Inside Runnable..");
        });

        Future<String> result = service.submit(() -> {
            System.out.println(Thread.currentThread().getName()+" Inside Callable Future..");
            return "SUCCESS";
        });

        System.out.println(result.get());
        service.shutdown();
    }
}
