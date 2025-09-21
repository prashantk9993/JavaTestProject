package designpatterns.structural.facade;

public class TransactionService {

    public void recordTransaction(String fromAccount, String toAccount, double amount){
        System.out.println("Account "+fromAccount+" has been debited of Rs. "+amount);
        System.out.println("Account "+toAccount+" has been credited of Rs. "+amount);
    }
}
