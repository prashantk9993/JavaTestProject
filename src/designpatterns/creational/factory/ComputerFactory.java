package designpatterns.creational.factory;

/*
* can keep factory class singleton
* can keep the method that return the subclass as static
*/

public class ComputerFactory {

    public static Computer getComputer(String type, String ram, String hdd, String cpu){

        if("PC".equalsIgnoreCase(type)) {
            return new PC(ram, hdd, cpu);
        } else if ("SERVER".equalsIgnoreCase(type)) {
            return new Server(ram, hdd, cpu);
        }
        return null;
    }
}
