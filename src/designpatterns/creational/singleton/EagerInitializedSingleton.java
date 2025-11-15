package designpatterns.creational.singleton;

public class EagerInitializedSingleton {

    private static final EagerInitializedSingleton eagerInitializedSingleton = new EagerInitializedSingleton();
    private EagerInitializedSingleton(){

    }

    public static EagerInitializedSingleton getInstance(){
        return eagerInitializedSingleton;
    }
}
