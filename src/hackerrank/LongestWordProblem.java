package hackerrank;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class LongestWordProblem {

  public static String LongestWord(String sen) {
    // code goes here  

  String[] arr = sen.split("[^A-Za-z]+");

  Optional<String> res =  Arrays.stream(arr).sorted(Comparator.comparingInt(String::length).reversed())
                                            .findFirst();
    return res.get();
  }

  public static void main (String[] args) {
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(LongestWord(s.nextLine()));
  }

}