import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {

  public static String LongestWord(String sen) {
    // code goes here


    Optional<Integer> len = Arrays.stream(sen.split(" ")).collect(Collectors.groupingBy(s -> s.length())).keySet().stream().max(Integer::compareTo);

    return len +" a";
  }

  public static void main (String[] args) {
    // keep this function call here
    Scanner s = new Scanner(System.in);
    System.out.print(LongestWord(s.nextLine()));
  }

}