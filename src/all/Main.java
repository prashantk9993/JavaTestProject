import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {

  /*public static String LongestWord(String sen) {
    // code goes here


    Optional<Integer> len = Arrays.stream(sen.split(" ")).collect(Collectors.groupingBy(s -> s.length())).keySet().stream().max(Integer::compareTo);

    return len +" a";
  }*/

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
   // System.out.print(LongestWord(s.nextLine()));

    List<Integer> lst = Arrays.asList(1,2,3,500,300,456);

    IntSummaryStatistics iss = lst.stream().collect(Collectors.summarizingInt(Integer::intValue));
    System.out.println(iss.getCount());
    System.out.println(iss.getSum());
  }


}
