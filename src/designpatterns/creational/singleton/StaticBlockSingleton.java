package designpatterns.creational.singleton;

public class StaticBlockSingleton {

    private StaticBlockSingleton(){

    }

    private static StaticBlockSingleton staticBlockSingleton;

    // static block initialization for exception handling
    static {
        try {
            staticBlockSingleton = new StaticBlockSingleton();
        } catch (Exception e) {
            throw new RuntimeException("Exception during creating singleton..");
        }
    }

    public static StaticBlockSingleton getInstance(){
        return staticBlockSingleton;
    }
}
