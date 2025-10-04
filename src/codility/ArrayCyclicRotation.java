package codility;

import java.util.Arrays;

public class ArrayCyclicRotation {
    public static void main(String[] args) {

        ArrayCyclicRotation obj = new ArrayCyclicRotation();
        int[] array1 = {3, 8, 9, 7, 6};
        int rotation = 3;
         Arrays.stream(obj.solution(array1,rotation)).forEach(s->System.out.print(s+" "));
    }

    public int[] solution(int[] A, int K){

        // Handle Edge Cases
        if(A == null || A.length == 0 || K ==0 ){
            return A;
        }

        int n = A.length;
        System.out.println("Array Length:::"+n);

        // Edge case scenario, if K is greater than length of Array , then find using %

        K = K % n;
        System.out.println("K Value:::"+K);

        if(K==0){
            return A;
        }

        // Create result Array
        // 1. copy the last K elements to the beginning
        int[] result = new int[n];

        for(int i = 0 ; i < K ; i++){
            result[i] = A[n-K+i];
        }
        // 2. copy the first n-K elements to the remaining

        for(int i = 0 ; i < n-K ;i++) {
            result[K+i] = A[i];
        }

        return result;
    }
}
