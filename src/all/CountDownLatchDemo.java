package all;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(5);
        System.out.println("Starting ....");
        // Started the thread
        new Thread(new MyThread(cdl)).start();
        try {
            // Awaiting thread to occurred 5 events
            cdl.await();
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        System.out.println("Done");
    }
}

class MyThread implements Runnable{
    CountDownLatch latch ;
    MyThread(CountDownLatch cdl){
        this.latch=cdl;
    }

    @Override
    public void run() {
        for(int i = 0; i<5; i++) {
            System.out.println(i);
            latch.countDown(); // decrement count on each event
        }
    }
}