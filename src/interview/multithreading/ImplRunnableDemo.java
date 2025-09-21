package interview.multithreading;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Running task in Runnable thread "+Thread.currentThread().getName());
    }
}

public class ImplRunnableDemo {
    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
