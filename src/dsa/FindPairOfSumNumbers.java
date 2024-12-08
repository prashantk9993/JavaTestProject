package dsa;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairOfSumNumbers {

    public static void main(String args[]) {
        int[] numbers = {2, 4, 3, 5, 7, 8, 9};
        int[] numbersWithDuplicates = {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};

        System.out.println("Pair for ====="+ Arrays.toString(numbers));
        printPairBruteForce(numbers,7);
        System.out.println("Pair for ====="+ Arrays.toString(numbersWithDuplicates));
        printPairBruteForce(numbersWithDuplicates,7);

        System.out.println("Using Set Pair for ====="+ Arrays.toString(numbers));
        printPairUSingSet(numbers,7);
        System.out.println("Using Set Pair for ====="+ Arrays.toString(numbersWithDuplicates));
        printPairUSingSet(numbersWithDuplicates,7);
    }

    public static void printPairBruteForce(int[] array, int sum){
        for (int i=0;i<array.length;i++){
            int first = array[i];
            for (int j = i+1;j<array.length;j++){
                int second = array[j];
                if((first+second)==sum){
                    System.out.println("Pair is ====="+first+"  "+second);
                }
            }
        }
    }
    //--------------------
    public static void printPairUSingSet(int[] array, int sum){
        if(array.length<2){
            return;
        }
        Set set = new HashSet(array.length);

        for (int value : array){
            // find target by value - given number and then search target in set
            int target = sum - value;
            if(!set.contains(target)){
                set.add(value);
            } else {
                System.out.println("Pair is "+value+" "+target);
            }
        }
    }
}