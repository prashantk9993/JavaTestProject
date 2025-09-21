package practice;

public class FindCountOfDigit {

    public static void main(String[] args) {
        int random = 232425282, digit = 2;
        System.out.println(findCount(random,digit));
        //System.out.println(random%10);
    }

    public static int findCount(int random, int digit){
        int count = 0 ;
        while (random>0){
            if(random%10==digit){
                count++;
            }
            random = random/10;
        }
        return count;
    }
}
