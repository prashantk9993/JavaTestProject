package all;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarrierAction());

        System.out.println("Starting");
        new Thread(new MyThreadCB(cb, "A")).start();
        new Thread(new MyThreadCB(cb, "B")).start();
        new Thread(new MyThreadCB(cb, "C")).start();

        new Thread(new MyThreadCB(cb, "X")).start();
        new Thread(new MyThreadCB(cb, "Y")).start();
        new Thread(new MyThreadCB(cb, "Z")).start();

        System.out.println("Main method end...");
    }
}

class MyThreadCB implements Runnable {
    CyclicBarrier cbar;
    String name;
    MyThreadCB(CyclicBarrier c, String n) {
        cbar = c;
        name = n;
    }

    @Override
    public void run() {
        System.out.println("Thread Starting ::::"+name);
        try {
            System.out.println("Thread Awaiting ::::"+name);
            cbar.await();
            System.out.println("Thread Done Awaiting ::::"+name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

class BarrierAction implements Runnable{
    @Override
    public void run() {
        System.out.println("Barrier Reached! and starting Barrier Action Thread");
    }
}