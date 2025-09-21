package designpatterns.structural.facade;

public class AuthenticationService {

    public boolean authenticate(String customerId, String password){
        return customerId.equalsIgnoreCase(password);
    }

}
