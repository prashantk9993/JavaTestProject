package codility;

import java.util.stream.IntStream;

public class BinaryGap {

    public static void main(String[] args) {

        BinaryGap obj = new BinaryGap();
       // System.out.println(obj.solution(100));  //1100100
        System.out.println(obj.solution2(100));
        //IntStream.rangeClosed(1,20).forEach(s -> System.out.println(Integer.toBinaryString(s)));
    }

    public int solution(int n){
        //Convert number to binary
        String binary = Integer.toBinaryString(n);
        System.out.println("Binary :::::"+binary);

        int maxGap = 0;
        int currentGap = 0;
        boolean counting = false;

        for (int i = 0 ; i < binary.length() ; i++){

            char current = binary.charAt(i);

            if (current == '1'){
                if(counting && currentGap > maxGap){
                    maxGap = currentGap;
                }
                counting = true;
                currentGap = 0;
            } else if (counting) {
                currentGap++;
            }
        }

        return maxGap;
    }

    public int solution2(int n){
        String binaryNumber = Integer.toBinaryString(n);

        int max = 0;
        int current = 0;
        boolean counter = false;

        for (int i = 0 ; i < binaryNumber.length(); i++){

            System.out.println("Chars "+ binaryNumber.charAt(i));

        if(binaryNumber.charAt(i) == '1'){

            if(counter && current > max){
                max = current;
            }
            counter = true;
            current = 0;
        } else if (counter){
            current ++;
        }


        }

        return max;
    }
}

