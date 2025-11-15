package multithread.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class BankingBatchProcessing {
    public static void main(String[] args) throws InterruptedException{

        // 4 files to process before starting calculations
        CountDownLatch latch = new CountDownLatch(4);

        System.out.println("Started files processing..");

        new Thread(new FileProcessor(latch, "ATM Transactions")).start();
        new Thread(new FileProcessor(latch, "Online Banking")).start();
        new Thread(new FileProcessor(latch, "UPI Payments")).start();
        new Thread(new FileProcessor(latch, "Credit Cards")).start();

        System.out.println("Main thread waiting for all files to process..");

        latch.await(); // waiting for all threads to call countDown();

        System.out.println("All files processed now starting the interest calculations..");

        runInterestCalculations();

    }

    private static void runInterestCalculations(){
        System.out.println("💰 Calculating daily interest for all accounts...");
        System.out.println("📊 EOD processing complete!");
    }
}


class FileProcessor implements Runnable {

    private CountDownLatch latch;
    private String fileName;


    public FileProcessor(CountDownLatch latch, String name) {
        this.latch= latch;
        this.fileName= name;
    }


    @Override
    public void run() {

        try {
            System.out.println(" Strated processing file "+fileName);
            Thread.sleep((long)(Math.random() * 3000) + 1000); // simulate time
            System.out.println("Processing finished for "+fileName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // as one finished the task , then decrease the counter
        }
    }
}