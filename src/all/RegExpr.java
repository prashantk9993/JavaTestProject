package all;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpr {
    public static void main(String[] args) {

        Pattern pat = Pattern.compile("Java");
        Matcher mat = pat.matcher("Java");

        if(mat.matches()){
            System.out.println("Equals...");
        } else {
            System.out.println("Not Equals...");
        }

        mat = pat.matcher("Java SE");

        if(mat.matches()){
            System.out.println("Equals...");
        } else {
            System.out.println("Not Equals...");
        }

        if(mat.find()){
            System.out.println("Contains...");
        } else {
            System.out.println("Not Contains...");
        }

        System.out.println("======================");
        Pattern pat1 = Pattern.compile("test");
        Matcher mat1 = pat1.matcher("test 1 2 3 test");

        while(mat1.find()){
            System.out.println("test found at index :"+mat1.start());
        }
        System.out.println("======================");

        String str = "aabbccddaaaeeeffgghiiij";
        String regex = "(.)\\1+";

        Pattern pat2 = Pattern.compile(regex);
        Matcher mat2 = pat2.matcher(str);

        while(mat2.find()){
            System.out.println("Found:"+mat2.group()+" at index "+mat2.start());
        }
        System.out.println("======================");
    }
}
