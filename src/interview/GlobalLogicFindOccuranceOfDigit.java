package interview;

public class GlobalLogicFindOccuranceOfDigit {

    public static void main(String[] args) {

        // random = 2324252, digit = 2, return -> 4
        // random = 2324252, digit = 5, return -> 1
        // random = 2324252, digit = 9, return -> -1

        System.out.println(getOccurance(2324252, 2));

    }

    public static int getOccurance(int random,int digit){
        int count = 0;
        while (random > 0){
            //last digit
            int lastDigit = random%10;
            if (lastDigit==digit){
                count++;
            }
            random = random /10;
        }

        return count;
    }
}
