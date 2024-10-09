// Demonstrate HashSet.
package all;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class HashSetDemo2 {
    public static void main(String[] args) {
// Create a hash set.
        HashSet<String> hs = new HashSet<String>();
// Add elements to the hash set.
        hs.add("Beta");
        hs.add("Alpha");
        hs.add("Eta");
        hs.add("Gamma");
        hs.add("Epsilon");
        hs.add("Omega");
        System.out.println(hs);

       List<String> s = (List<String>) IntStream.rangeClosed(1, 15)
               .mapToObj(p-> ( p%3==0 && p%5==0) ? "FizzBuzz" : p%5==0 ? "Buzz" : p%3==0 ? "Fizz" :  p+"")
               .collect(Collectors.toList());

       s.forEach(a->System.out.println(a));
    }
}