package multithread.sample;

import java.util.Random;

// Main Application
public class ECommerceApplication {
    
    private final OrderProcessingService orderService;
    
    public ECommerceApplication() {
        this.orderService = new OrderProcessingService();
    }
    
    public void simulateLoad() {
        Random random = new Random();
        
        // Simulate 20 orders coming in
        for (int i = 1; i <= 20; i++) {
            String orderId = "ORD_" + i;
            String customerId = "CUST_" + (i % 5 + 1);
            double amount = 50 + random.nextInt(500);
            
            Order order = new Order(orderId, customerId, amount);
            
            orderService.submitOrder(order)
                .thenAccept(processedOrder -> {
                    System.out.println("Order completed: " + processedOrder.getOrderId() + 
                                     " Status: " + processedOrder.getStatus());
                })
                .exceptionally(ex -> {
                    System.err.println("Order failed: " + orderId + " - " + ex.getMessage());
                    return null;
                });
            
            // Add some delay between orders
            try {
                Thread.sleep(100 + random.nextInt(400));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    public void shutdown() {
        orderService.shutdown();
    }
    
    public static void main(String[] args) {
        ECommerceApplication app = new ECommerceApplication();
        
        // Add shutdown hook for graceful shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(app::shutdown));
        
        try {
            app.simulateLoad();
            
            // Keep the application running for a while
            Thread.sleep(30000);
            
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            app.shutdown();
        }
    }
}