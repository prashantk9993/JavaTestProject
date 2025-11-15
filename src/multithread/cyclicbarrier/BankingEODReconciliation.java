package multithread.cyclicbarrier;

//Scenario: End-of-Day (EOD) Transaction Reconciliation
//In a bank, at the end of the day:
//1. Data comes from multiple systems — ATM, Online Banking, Credit Card, UPI, etc.
//2. Each system must process and validate its transactions.
//3. Only when all systems finish their part can the bank run the final reconciliation report.
//Multiple threads (each handling one system) work independently,
//but must all reach the barrier before the final “EOD Reconciliation” starts.

import java.util.concurrent.CyclicBarrier;

public class BankingEODReconciliation {

    public static void main(String[] args) {
    // Barrier for 4 systems + 1 final action
    CyclicBarrier barrier = new CyclicBarrier(4, ()-> {
        System.out.println(" All systems processed! Running final reconciliation report...");
        runFinalReconciliation();
    });

    // Launch threads for different systems
    new Thread(new EODSystem(barrier,"ATM Transaction")).start();
    new Thread(new EODSystem(barrier,"Online Banking")).start();
    new Thread(new EODSystem(barrier,"Credit Card")).start();
    new Thread(new EODSystem(barrier,"UPI Payments")).start();
    }

    private static void runFinalReconciliation() {
        System.out.println("🔍 Consolidating all reports...");
        System.out.println("💰 Reconciliation successful! All ledgers balanced.\n");
    }
}

class EODSystem implements Runnable {

    private CyclicBarrier barrier;
    private String systemName;

    EODSystem(CyclicBarrier barrier, String systemName) {
        this.barrier = barrier;
        this.systemName = systemName;
    }

    @Override
    public void run() {
        try {
            System.out.println(systemName + " - Processing started...");
            Thread.sleep((long)(Math.random() * 3000) + 1000); // simulate processing time
            System.out.println(systemName + " - Completed processing.");

            barrier.await(); // wait for all systems to complete

            // After barrier action completes (reconciliation), all systems can proceed
            System.out.println(systemName + " - Archiving records...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
