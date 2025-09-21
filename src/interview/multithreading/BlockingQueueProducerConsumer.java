package interview.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueProducerConsumer {

    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        Runnable producer = () -> {
            try {
            for (int i = 1 ; i <= 10 ; i++){
                    // can put only 5 elements, since size is 5 , after consuming 5 will add remaining
                    queue.put(i);
                System.out.println("Produced: " + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable consumer = () -> {
            try {
                    for (int i = 1 ;i <= 10 ; i++){
                        queue.take();
                        System.out.println("Consumed: " + i);
                    }
            }catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
