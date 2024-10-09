package all;
import java.util.concurrent.Semaphore;

public class SemaphoreDemno {
    public static void main(String[] args) {
        Semaphore sem = new Semaphore(1);
        new Thread(new IncrementThread(sem, "A")).start();
        new Thread(new DecrementThread(sem,"B")).start();
    }
}

// A shared resource.
class Shared {
    static int count = 0;
}

class IncrementThread implements Runnable {
    String name;
    Semaphore sem;

    IncrementThread(Semaphore sem , String name){
        this.name=name;
        this.sem=sem;
    }

    @Override
    public void run() {

        System.out.println("Starting Thread ::"+name);
        try{
            // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");
           // Now, access shared resource.
            for(int i=0; i < 5; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
           // Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        // Release the permit.
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}

// A thread of execution that decrements count.
class DecrementThread implements Runnable {
    String name;
    Semaphore sem;

    DecrementThread(Semaphore s, String n) {
        sem = s;
        name = n;
    }
    public void run() {
        System.out.println("Starting Thread ::" + name);
        try {
        // First, get a permit.
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");
        // Now, access shared resource.
            for(int i=0; i < 5; i++) {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
        // Now, allow a context switch -- if possible.
                Thread.sleep(10);
            }
        } catch (InterruptedException exc) {
            System.out.println(exc);
        }
        // Release the permit.
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}