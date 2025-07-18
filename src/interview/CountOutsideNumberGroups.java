package interview;

public class CountOutsideNumberGroups {
    public static void main(String[] args) {
        String s2 = "asedr1aaaw2aff3aa";

        int count = 0;
        boolean inNumberGroup = false;

        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);

            if (Character.isDigit(ch)) {
                inNumberGroup = true; // start skipping until next non-letter
            } else if (inNumberGroup) {
                // Continue skipping letters after a digit
                if (!Character.isLetter(ch)) {
                    inNumberGroup = false;
                }
                // Don't count these
            } else {
                // Not in number group, count letters
                if (Character.isLetter(ch)) {
                    count++;
                }
            }
        }

        System.out.println("Count of characters outside number groups: " + count);
    }
}
