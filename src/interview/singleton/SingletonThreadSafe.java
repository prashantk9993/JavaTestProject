package interview.singleton;

public class SingletonThreadSafe {

    private static SingletonThreadSafe instance;

    private SingletonThreadSafe(){}

    // Synchronized the instance creating method to achieve thread safety
    synchronized public static SingletonThreadSafe getInstance(){
        if (instance==null){
            instance = new SingletonThreadSafe();
        }
        return instance;
    }
}
