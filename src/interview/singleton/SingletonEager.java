package interview.singleton;

public class SingletonEager {

    // In eager initialization the object is created before required and returned whenever requested
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance(){
        return instance;
    }
}
