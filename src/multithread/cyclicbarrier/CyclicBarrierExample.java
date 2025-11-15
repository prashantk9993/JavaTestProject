package multithread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    //  👉 A CyclicBarrier is a synchronization aid that lets a group of threads wait for
    //  each other at a common point (called a barrier).
    //  Once all threads reach the barrier, they all proceed together.

   // Imagine four friends (threads) running towards a meeting point (the barrier).
   // None of them can move forward until everyone arrives.
   // Once all four reach the meeting point → they all start running again together.

    // syntax
    // 1. CyclicBarrier barrier = new CyclicBarrier(int parties);
    // 2. CyclicBarrier barrier = new CyclicBarrier(int parties, Runnable barrierAction); //with an action to run once all threads reach the barrier:

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> {
            System.out.println("All have arrived! Let's start climbing ⛰️");
        });

        for (int i = 1; i <= 3; i++) {
            new Thread(new Trekker(cyclicBarrier, i)).start();
        }
    }
}

class Trekker implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private int id;

    Trekker(CyclicBarrier cyclicBarrier, int id) {
        this.cyclicBarrier = cyclicBarrier;
        this.id = id;
    }

    public void run() {
        try {
            System.out.println("Trekker " + id + " is on the way...");
            Thread.sleep(1000 * id); // simulate different arrival times
            System.out.println("Trekker " + id + " reached the base camp!");
            cyclicBarrier.await(); // wait for others
            // After this we can do common task
            System.out.println("Trekker " + id + " started climbing!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}