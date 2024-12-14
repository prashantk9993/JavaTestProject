package dsa;

public class CountNumberOfWords {

    public static void main(String[] args) {
        String input1 = "This is a sample line of text\n" +
                "This is another line of text\n" +
                "This line is the 3rd line\n" +
                "This junk line contains 989902 99dsaWjJ8           015\n" +
                "This is the fifth and the last line of input";

        String input2 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        System.out.println(getCount(input1.replaceAll("  ","")));
        System.out.println(getCount(input2.replaceAll("  ","")));


    }

    public static int getCount(String input){
        return input.split("\\s").length;
    }
}
