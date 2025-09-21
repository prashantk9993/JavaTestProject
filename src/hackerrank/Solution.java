package hackerrank;
import java.util.Scanner;

class Solution{

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }

    }
}

class MyRegex {
 //String num = "(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,3})";
  //  String pattern = num + "\\." + num + "\\." + num + "\\." + num;

        String num = "(?:25[0-5]|2[0-4][0-9]|1[0-9]{2}|0[0-9]{2}|[0-9]{1,2})";
        String pattern = "^" + num + "\\." + num + "\\." + num + "\\." + num + "$";
}
