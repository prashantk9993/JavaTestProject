package practice;

import java.util.*;

class Solution {

    //For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

    //Given A = [1, 2, 3], the function should return 4.

    //Given A = [−1, −3], the function should return 1.

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums =  {1, 3, 6, 4, 1, 2};
        int[] nums2 =  {1, 2, 3};
        int[] nums3 = {-1, -3};
        System.out.println(s.solution(nums));
        System.out.println(s.solution(nums2));
        System.out.println(s.solution(nums3));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int smallestMissing = 1; // Smallest positive integer
        
        for (int num : A) {
            if (num == smallestMissing) {
                smallestMissing++;
            } else if (num > smallestMissing) {
                // We found a gap, return the current smallest missing
                return smallestMissing;
            }
            // If num < smallestMissing or negative, we just skip
        }
        
        return smallestMissing;
    }
}