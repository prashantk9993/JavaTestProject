package multithread.sample;

import java.util.concurrent.*;
import java.util.*;
import java.time.LocalDateTime;

// Domain Models
class Order {
    private String orderId;
    private String customerId;
    private double amount;
    private OrderStatus status;
    private LocalDateTime createdAt;
    
    public Order(String orderId, String customerId, double amount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.amount = amount;
        this.status = OrderStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    
    // Getters and setters
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public double getAmount() { return amount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}

enum OrderStatus {
    PENDING, PROCESSING, PAYMENT_SUCCESS, PAYMENT_FAILED, COMPLETED, FAILED
}

class PaymentResult {
    private boolean success;
    private String transactionId;
    private String message;
    
    public PaymentResult(boolean success, String transactionId, String message) {
        this.success = success;
        this.transactionId = transactionId;
        this.message = message;
    }
    
    public boolean isSuccess() { return success; }
    public String getTransactionId() { return transactionId; }
    public String getMessage() { return message; }
}