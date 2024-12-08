package dsa;

import java.util.Arrays;

public class RemoveDuplicateFromArray {

    public static void main(String args[]) {

        int[][] test = new int[][]{
                {1, 1, 2, 2, 3, 4, 5},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 2, 3, 4, 5, 6, 7},
                {1, 2, 1, 1, 1, 1, 1},};

        for (int[] input : test) {
            System.out.println("Array with Duplicates       : " + Arrays.toString(input));
            System.out.println("After removing duplicates   : " + Arrays.toString(removeDuplicates(input)));
            System.out.println("========================= : " );
        }
    }

    /*
     * Method to remove duplicates from array in Java, without using
     * Collection classes e.g. Set or ArrayList. Algorithm for this
     * method is simple, it first sort the array and then compare adjacent
     * objects, leaving out duplicates, which is already in the result.
     */

    public static int[] removeDuplicates(int[] numbersWithDuplicates) {

        //sort the array to bring duplicate together
        Arrays.sort(numbersWithDuplicates);
       // System.out.println("Sorted arrayt"+Arrays.toString(numbersWithDuplicates));

        // Create result array
        int[] result = new int[numbersWithDuplicates.length];

        // get previous number
        int previous = numbersWithDuplicates[0];

        //System.out.println("previous :::::"+previous);

        result[0]=previous;

for (int i = 1 ;i < numbersWithDuplicates.length;i++){
    int next = numbersWithDuplicates[i];

    if(previous != next){
        result[i]=next; // if not equal then add next element in result
    }
    previous=next; // not adding element in result hence 0

}

        return result;
    }
 }
