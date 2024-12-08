package dsa;

import java.util.Arrays;
import java.util.BitSet;

public class FindMissingNumberInArrays {

    public static void main(String[] args) {

           // one missing number
            printMissingNumber(new int[]{1, 2, 3, 4, 6}, 6);
            getMissingNumberUsingBitset(new int[]{1, 2, 3, 4, 6}, 6);

            // two missing number
            printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);

            // three missing number
            printMissingNumber(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);
         getMissingNumberUsingBitset(new int[]{1, 2, 3, 4, 6, 9, 8}, 10);

            // four missing number
            printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);

            // Only one missing number in array
            int[] iArray = new int[]{1, 2, 3, 5};
            int missing = getMissingNumber(iArray, 5);
            System.out.printf("Missing number in array %s is %d %n",
                    Arrays.toString(iArray), missing);
        }
        /**
         * A general method to find missing values from an integer array in Java.
         * This method will work even if array has more than one missing element.
         */
        private static void printMissingNumber(int[] numbers, int count) {
            System.out.println("====Method 1 ==========");
            int missingCount = count - numbers.length;
            BitSet bitSet = new BitSet(count);



            for (int number : numbers) {
                bitSet.set(number - 1);
            }
            System.out.println("bitSet============="+bitSet);

            System.out.printf("Missing numbers in integer array %s, with total number %d is %n",
                    Arrays.toString(numbers), count);
            int lastMissingIndex = 0;

            for (int i = 0; i < missingCount; i++) {
                lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
                System.out.println(++lastMissingIndex);
            }

        }
        /**
         * Java method to find missing number in array of size n containing
         * numbers from 1 to n only.
         * can be used to find missing elements on integer array of
         * numbers from 1 to 100 or 1 - 1000
         */
        private static int getMissingNumber(int[] numbers, int totalCount) {
            System.out.println("====Method 2 ==========");
            int expectedSum = totalCount * ((totalCount + 1) / 2);
            int actualSum = 0;
            for (int i : numbers) {
                actualSum += i;
            }

            return expectedSum - actualSum;
        }

        //---- tried

    private static void getMissingNumberUsingBitset(int[] numbers, int totalCount){

            int missingNumbersCount = totalCount-numbers.length;

            BitSet bitSet = new BitSet(totalCount);

            for (int number : numbers){
                bitSet.set(number-1);
            }

            int actualMissingNumbers = 0;

            for (int i = 0; i<missingNumbersCount;i++){
                actualMissingNumbers = bitSet.nextClearBit(actualMissingNumbers);
                System.out.println("Actual missing numbers test :::::::") ;
                System.out.println(++actualMissingNumbers) ;
            }
          //  return actualMissingNumbers;
    }


    }

