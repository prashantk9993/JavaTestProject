package designpatterns.structural.facade;

public class NotificationService {

    public void sendConfirmation(String customerId, double amount){
        System.out.println("Dear customer, your account has been debited of Rs. "+amount);
    }
}
