package practice;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread is running by implementing Runnable: " + Thread.currentThread().getName());
    }
}

public class Main {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        // Using a Lambda (Java 8+), since Runnable is a functional interface
        Thread lambdaThread = new Thread(() -> {
            System.out.println("Thread with Lambda: " + Thread.currentThread().getName());
        });
        lambdaThread.start();
    }
}