package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HackerRankAnagram {
    public static void main(String[] args) {

        // find anagrams
        String [] array = {"cat","dog","tac","god","act","mat","tam","tar"};

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : array){
            char [] letters = str.toCharArray();
            Arrays.sort(letters);

            String newString = new String(letters);

            if(map.containsKey(newString)){
                map.get(newString).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(newString, newList);
            }
        }

        for(List<String> lst : map.values()){
            if (lst.size()>1){
                System.out.println(lst);
            }
        }

    }
}
