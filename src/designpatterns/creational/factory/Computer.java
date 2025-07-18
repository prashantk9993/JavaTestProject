package designpatterns.creational.factory;

/*
 * superclass in factory design pattern can be an Interface,
 * abstract class or normal java class
 */

public abstract class Computer {
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();

    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
