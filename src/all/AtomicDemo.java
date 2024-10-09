package all;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicDemo {
    public static void main(String[] args) {
        new Thread(new AtomThread("A")).start();
        new Thread(new AtomThread("B")).start();
        new Thread(new AtomThread("C")).start();
    }
}

//AtomicInteger need not synchronizing mechanism
class Shared2 {
    static AtomicInteger ai = new AtomicInteger(0);
}

// A thread of execution that increments count.
class AtomThread implements Runnable {
    String name;

    AtomThread(String n) {
        name = n;
    }

    public void run() {
        System.out.println("Starting " + name);
        for (int i = 1; i <= 3; i++)
            System.out.println(name + " got: " +
                    Shared2.ai.getAndSet(i));
    }
}