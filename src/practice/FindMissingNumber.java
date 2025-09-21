package practice;

import java.util.Arrays;

public class FindMissingNumber {
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,6,7,8,9,10};
        System.out.println(missingNumber(nums));
    }

    static int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = Arrays.stream(nums).sum();
        return expectedSum - actualSum;
    }

}
