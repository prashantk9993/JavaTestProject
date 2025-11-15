package designpatterns.creational.singleton;

public class LazyInitializedSingleton {

    private LazyInitializedSingleton(){}

    private static LazyInitializedSingleton lazyInitializedSingleton;

    public static LazyInitializedSingleton getInstance(){
        if(lazyInitializedSingleton==null){
            lazyInitializedSingleton = new LazyInitializedSingleton();
        }
        return lazyInitializedSingleton;
    }
}
