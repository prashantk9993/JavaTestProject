package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrefixSearch {
    public static void main(String[] args) {

        List<String> items = Arrays.asList(
                "computer", "car", "iphone", "cooker", "iron",
                "fan", "television", "camera", "laptop", "mobile", "mug", "cup"
        );

        Scanner sc = new Scanner(System.in);

        while (true){

            System.out.print("Enter search text (or 'exit' to quit): ");
            String search = sc.nextLine().toLowerCase();

            if (search.equals("exit")) break;

            // Filter items that start with user input
            List<String> result = items.stream()
                    .sorted()
                    .filter(item ->
                    item.toLowerCase().startsWith(search)).limit(3).collect(Collectors.toList());

            if (result.isEmpty()) {
                System.out.println("No items found.");
            } else {
                System.out.println("Matches: " + result);
            }

        }

    }
}
