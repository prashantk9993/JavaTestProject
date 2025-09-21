package interview.multithreading;

import java.util.concurrent.*;

class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "This is call method running thread task...";
    }
}

public class ImplCallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyCallable callable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(callable);

        //FutureTask extends both Runnable and Future
        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("Return result is ::"+futureTask.get());

        // another way using executor
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(new MyCallable());

        System.out.println("Doing other work in main thread...");

        String result = future.get(); // This blocks until the result is available
        System.out.println(result);

        executor.shutdown(); // Always shut down the executor
    }
}
