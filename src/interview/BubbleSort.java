package interview;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] numbers = { 5, 56, 23, 4, 55, 87, 23, 45, 9, 78, 56 };

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] > numbers[j]) {
					int temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
			}
		}
		Arrays.stream(numbers).forEach(System.out::println);
	}

}
