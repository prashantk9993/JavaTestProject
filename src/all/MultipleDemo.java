package all;
public class MultipleDemo implements Beta{
    public static void main(String[] args) {

        MultipleDemo md = new MultipleDemo();
        md.reset();
    }

    /*public   void reset(){
        System.out.println("Class reset");
    }*/
}

interface Alfa {
    public default void reset(){
        System.out.println("Alfa reset");
    }
}

interface Beta  {
    public default void reset(){
        System.out.println("Beta reset");
    }
}