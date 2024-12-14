package centralbank;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ReadInputFromConsole {

    public static void main(String[] args) throws IOException, IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter values 1:::::");
        System.out.println(s.nextLine());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter values 2:::::");
        System.out.println(br.readLine());


        //-----------
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter numeric value");
        System.out.println(sc1.nextLine());

        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter String value");
        System.out.println(br.readLine());
    }
}
