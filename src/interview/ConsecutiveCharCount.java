package interview;

public class ConsecutiveCharCount {
    public static void main(String[] args) {
        String input = "AAABBCCCCAA";
        StringBuilder result = new StringBuilder();

        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                result.append(input.charAt(i - 1)).append(count).append(" ");
                count = 1;
            }
        }

        // Append the last group
        result.append(input.charAt(input.length() - 1)).append(count);

    //    System.out.println("Length::::::"+result.length());
     //   System.out.println(result.toString());


        int countt = 1;

        for (int i = 1 ;i < input.length(); i++){

            if(input.charAt(i) == input.charAt(i-1)){
                countt++;
            } else {
                System.out.println(input.charAt(i-1)+" --- "+countt);
                countt = 1;
            }
        }
        System.out.println(input.charAt(input.length()-1)+" --- "+countt);
    }
}
