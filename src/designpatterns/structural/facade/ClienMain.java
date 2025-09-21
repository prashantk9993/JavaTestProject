package designpatterns.structural.facade;

public class ClienMain {
    public static void main(String[] args) {
        BankingFacade facade = new BankingFacade();

        boolean success = facade.transferFunds("cust123","cust13","123","456",5000);

        if(success){
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Transfer Failed!");
        }
    }
}
