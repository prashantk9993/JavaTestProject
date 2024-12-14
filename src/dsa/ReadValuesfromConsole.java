package dsa;

import java.awt.geom.FlatteningPathIterator;
import java.util.Scanner;

public class ReadValuesfromConsole {

    public static void main(String[] args) {
        System.out.println("Enter 3 values space separated");
        Scanner sc = new Scanner(System.in);
      //  System.out.println(sc.nextLine());
        String[] arr = sc.nextLine().split(" ");

        float side1 = Float.valueOf(arr[0]);
        float side2 = Float.valueOf(arr[1]);
        float side3 = Float.valueOf(arr[2]);

        System.out.println(side1);
        System.out.println(side2);
        System.out.println(side3);
        if((side1*side1)+(side2*side2)==side3*side3){
            System.out.println("Right angle triangle");
        }else {
            System.out.println("Other triangle");
        }
    }
}
