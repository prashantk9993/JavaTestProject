package all;

public class TestNumbers {
    // Inputs and outputs
    // (random = 2324252, digit = 2 ) return -> 4
    // (random = 2324252, digit = 5 ) return -> 1
    // (random = 2324252, digit = 9 ) return -> -1
    public static void main(String[] args) {
        TestNumbers obj = new TestNumbers();
        System.out.println(obj.findDigitCount(2324252,2));
    }

    int findDigitCount(int random, int digit){
        int count = 0;

        while (random > 0){
           // get last digit
            int lastDigit = random%10;
            if(lastDigit == digit){
                count++;
            }
            // remove last digit from random number
            random = random/10;
        }
        return count;
    }
}
