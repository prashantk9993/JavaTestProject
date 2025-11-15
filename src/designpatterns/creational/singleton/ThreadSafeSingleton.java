package designpatterns.creational.singleton;

public class ThreadSafeSingleton {

    private ThreadSafeSingleton(){}

    private static ThreadSafeSingleton threadSafeSingleton;

    public static synchronized ThreadSafeSingleton getInstance(){
        if(threadSafeSingleton == null) {
            threadSafeSingleton = new ThreadSafeSingleton();
        }
        return threadSafeSingleton;
    }
}
