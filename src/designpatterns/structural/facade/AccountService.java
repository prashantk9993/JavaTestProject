package designpatterns.structural.facade;

public class AccountService {

    public boolean hasSufficientFund(String fromAccount, double amount){
        System.out.println("Checking sufficient fund....");
        System.out.println("Account having sufficient fund....");
        return true;
    }

    public void debit(String fromAccount, double amount){
        System.out.println("Debited amount of "+amount+" from account "+fromAccount);
    }

    public void credit(String toAccount, double amount){
        System.out.println("Account "+toAccount+" has been credited of Rs. "+amount);
    }

}
