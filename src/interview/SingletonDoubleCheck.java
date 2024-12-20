package interview;

public class SingletonDoubleCheck {

    private static SingletonDoubleCheck instance;

    private SingletonDoubleCheck(){}

    public static SingletonDoubleCheck getInstance(){
        //First check
        if(instance==null){ // if more than 1 threads accessed simulteneusly
            synchronized (SingletonDoubleCheck.class){ // then synchronized block will stop one thread
                //Second check
                if(instance==null){   // first thread pass, second thread will not pass
                   // If instance is null then initialize
                    instance = new SingletonDoubleCheck();
                }
            }
        }
        return instance;
    }
}
