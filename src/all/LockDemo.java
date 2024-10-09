package all;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(new LockThread(lock, "A")).start();
        new Thread(new LockThread(lock, "B")).start();
    }
}

// A shared resource.
class Shared1 {
    static int count = 0;
}

// A thread of execution that increments count.
class LockThread implements Runnable {
    String name;
    ReentrantLock lock;
    LockThread(ReentrantLock lk, String n) {
        lock = lk;
        name = n;
    }
    public void run() {
        System.out.println("Starting " + name);
    try {
// First, lock count.
        System.out.println(name + " is waiting to lock count.");
        lock.lock();
        System.out.println(name + " is locking count.");
        Shared.count++;
        System.out.println(name + ": " + Shared.count);
// Now, allow a context switch -- if possible.
        System.out.println(name + " is sleeping.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } finally {
// Unlock
        System.out.println(name + " is unlocking count.");
        lock.unlock();
    }
}
}
