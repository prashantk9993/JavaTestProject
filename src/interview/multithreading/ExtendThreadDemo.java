package interview.multithreading;

class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("Running task in thread...."+Thread.currentThread().getName());
    }
}

public class ExtendThreadDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("==========..");
    }
}
