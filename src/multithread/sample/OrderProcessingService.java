package multithread.sample;

import java.util.Map;
import java.util.concurrent.*;

// Order Processing Service
public class OrderProcessingService {
    
    // Different thread pools for different priorities
    private final ExecutorService highPriorityExecutor;
    private final ExecutorService mediumPriorityExecutor;
    private final ExecutorService lowPriorityExecutor;
    private final ScheduledExecutorService scheduledExecutor;
    
    // In-memory storage (would be database in real app)
    private final Map<String, Order> orderStore = new ConcurrentHashMap<>();
    private final BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();
    
    public OrderProcessingService() {
        // High priority: For payment processing (immediate execution)
        highPriorityExecutor = Executors.newFixedThreadPool(2);
        
        // Medium priority: For inventory and notifications
        mediumPriorityExecutor = Executors.newFixedThreadPool(4);
        
        // Low priority: For analytics and reporting
        lowPriorityExecutor = Executors.newFixedThreadPool(2);
        
        // Scheduled executor for periodic tasks
        scheduledExecutor = Executors.newScheduledThreadPool(1);
        
        startOrderProcessing();
        startMonitoring();
    }
    
    // Submit a new order for processing
    public CompletableFuture<Order> submitOrder(Order order) {
        orderStore.put(order.getOrderId(), order);
        orderQueue.offer(order);
        
        return CompletableFuture.supplyAsync(() -> {
            try {
                processOrder(order);
                return order;
            } catch (Exception e) {
                order.setStatus(OrderStatus.FAILED);
                throw new CompletionException(e);
            }
        }, highPriorityExecutor);
    }
    
    private void startOrderProcessing() {
        // Process orders from queue
        mediumPriorityExecutor.submit(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Order order = orderQueue.take();
                    processOrderBackground(order);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
    }
    
    private void startMonitoring() {
        // Monitor system health every 30 seconds
        scheduledExecutor.scheduleAtFixedRate(() -> {
            System.out.println("=== System Monitoring ===");
            System.out.println("Orders in queue: " + orderQueue.size());
            System.out.println("Active threads - High: " + ((ThreadPoolExecutor)highPriorityExecutor).getActiveCount());
            System.out.println("Active threads - Medium: " + ((ThreadPoolExecutor)mediumPriorityExecutor).getActiveCount());
            System.out.println("Active threads - Low: " + ((ThreadPoolExecutor)lowPriorityExecutor).getActiveCount());
            System.out.println("=========================");
        }, 0, 30, TimeUnit.SECONDS);
    }
    
    private void processOrder(Order order) {
        order.setStatus(OrderStatus.PROCESSING);
        System.out.println("Processing order: =========================== " + order.getOrderId());
        
        // Step 1: Process payment (High priority)
        PaymentResult paymentResult = processPayment(order);
        
        if (paymentResult.isSuccess()) {
            order.setStatus(OrderStatus.PAYMENT_SUCCESS);
            
            // Step 2: Update inventory (Medium priority)
            mediumPriorityExecutor.submit(() -> updateInventory(order));
            
            // Step 3: Send confirmation email (Medium priority)
            mediumPriorityExecutor.submit(() -> sendConfirmationEmail(order));
            
            // Step 4: Analytics (Low priority)
            lowPriorityExecutor.submit(() -> trackAnalytics(order));
            
            order.setStatus(OrderStatus.COMPLETED);
        } else {
            order.setStatus(OrderStatus.PAYMENT_FAILED);
            mediumPriorityExecutor.submit(() -> sendFailureNotification(order, paymentResult.getMessage()));
        }
    }
    
    private void processOrderBackground(Order order) {
        // Background processing for non-critical tasks
        lowPriorityExecutor.submit(() -> {
            generateOrderReport(order);
            archiveOrderData(order);
        });
    }
    
    // Simulated service methods
    private PaymentResult processPayment(Order order) {
        try {
            Thread.sleep(100); // Simulate payment processing time
            return new PaymentResult(true, "TXN_" + System.currentTimeMillis(), "Payment successful");
        } catch (InterruptedException e) {
            return new PaymentResult(false, null, "Payment processing interrupted");
        }
    }
    
    private void updateInventory(Order order) {
        try {
            Thread.sleep(200);
            System.out.println("Inventory updated for order: " + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void sendConfirmationEmail(Order order) {
        try {
            Thread.sleep(150);
            System.out.println("Confirmation email sent for order: " + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void sendFailureNotification(Order order, String reason) {
        try {
            Thread.sleep(100);
            System.out.println("Failure notification sent for order: " + order.getOrderId() + " - Reason: " + reason);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void trackAnalytics(Order order) {
        try {
            Thread.sleep(50);
            System.out.println("Analytics tracked for order: " + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void generateOrderReport(Order order) {
        try {
            Thread.sleep(300);
            System.out.println("Report generated for order: " + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    private void archiveOrderData(Order order) {
        try {
            Thread.sleep(100);
            System.out.println("Order data archived: ==============================" + order.getOrderId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    // Graceful shutdown
    public void shutdown() {
        System.out.println("Initiating graceful shutdown...");
        
        highPriorityExecutor.shutdown();
        mediumPriorityExecutor.shutdown();
        lowPriorityExecutor.shutdown();
        scheduledExecutor.shutdown();
        
        try {
            if (!highPriorityExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                highPriorityExecutor.shutdownNow();
            }
            if (!mediumPriorityExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                mediumPriorityExecutor.shutdownNow();
            }
            if (!lowPriorityExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                lowPriorityExecutor.shutdownNow();
            }
            if (!scheduledExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduledExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        System.out.println("All executors shutdown complete");
    }
    
    public ExecutorService getHighPriorityExecutor() {
        return highPriorityExecutor;
    }
}