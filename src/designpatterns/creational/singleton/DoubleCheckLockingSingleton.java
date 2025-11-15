package designpatterns.creational.singleton;

public class DoubleCheckLockingSingleton {

    private DoubleCheckLockingSingleton(){}

    private static DoubleCheckLockingSingleton doubleCheckLockingSingleton;

    public static DoubleCheckLockingSingleton getInstance(){
        if(doubleCheckLockingSingleton == null){
            synchronized (DoubleCheckLockingSingleton.class){
                if(doubleCheckLockingSingleton == null){
                    doubleCheckLockingSingleton = new DoubleCheckLockingSingleton();
                }
            }
        }
        return doubleCheckLockingSingleton;
    }
}
