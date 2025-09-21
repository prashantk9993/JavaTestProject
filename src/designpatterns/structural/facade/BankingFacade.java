package designpatterns.structural.facade;

public class BankingFacade {

    private AuthenticationService authenticationService;
    private AccountService accountService;
    private TransactionService transactionService;
    private NotificationService notificationService;
    private AuditService auditService;

    public BankingFacade(){
        this.authenticationService = new AuthenticationService();
        this.accountService = new AccountService();
        this.transactionService = new TransactionService();
        this.notificationService = new NotificationService();
        this.auditService = new AuditService();
    }

    public boolean transferFunds(String customerId, String password,
                                 String fromAcc, String toAcc, double amount){

        if(!authenticationService.authenticate(customerId,password)){
            return false;
        }

        if(!accountService.hasSufficientFund(fromAcc,amount)){
            return false;
        }

        accountService.debit(fromAcc,amount);
        accountService.credit(toAcc,amount);
        transactionService.recordTransaction(fromAcc,toAcc,amount);
        notificationService.sendConfirmation(customerId,amount);
        auditService.log("Fund transfered of amount "+amount);
        return true;
    }
}
