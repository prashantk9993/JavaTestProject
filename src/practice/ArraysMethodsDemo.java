package practice;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysMethodsDemo {
    public static void main(String[] args) {
        // Sample arrays for demonstration
        int[] numbers = {5, 2, 8, 1, 9};

        String[] names = {"John", "Alice", "Bob", "Charlie"};
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        
        System.out.println("Original array: " + Arrays.toString(numbers));
        System.out.println("Original array: " +  numbers.length);

        // 1. sort() - Sorts the array
        Arrays.sort(numbers);
        System.out.println("After sort: " + Arrays.toString(numbers));
        
        // 2. sort() with range
        int[] nums = {5, 2, 8, 1, 9, 3, 7};
        Arrays.sort(nums, 2, 5); // Sort from index 2 to 4 (exclusive)
        System.out.println("Sort range [2,5): " + Arrays.toString(nums));
        
        // 3. sort() with Comparator for Objects
        Arrays.sort(names, Comparator.reverseOrder());
        System.out.println("Names reverse sorted: " + Arrays.toString(names));
        
        // 4. binarySearch() - Searches for element (array must be sorted)
        int index = Arrays.binarySearch(numbers, 8);
        System.out.println("Binary search for 8: index = " + index);
        
        // 5. binarySearch() with range
        int[] sortedNums = {1, 3, 5, 7, 9, 11, 13};
        int rangeIndex = Arrays.binarySearch(sortedNums, 2, 6, 9);
        System.out.println("Binary search in range [2,6) for 9: " + rangeIndex);
        
        // 6. equals() - Checks if two arrays are equal
        boolean isEqual = Arrays.equals(array1, array2);
        System.out.println("Arrays equal: " + isEqual);
        
        // 7. deepEquals() - For multidimensional arrays
        int[][] multi1 = {{1, 2}, {3, 4}};
        int[][] multi2 = {{1, 2}, {3, 4}};
        boolean deepEqual = Arrays.deepEquals(multi1, multi2);
        System.out.println("Multi-dimensional arrays equal: " + deepEqual);
        
        // 8. fill() - Fills array with specified value
        int[] fillArray = new int[5];
        Arrays.fill(fillArray, 42);
        System.out.println("After fill with 42: " + Arrays.toString(fillArray));
        
        // 9. fill() with range
        int[] rangeFill = new int[6];
        Arrays.fill(rangeFill, 1, 4, 99); // Fill index 1 to 3 with 99
        System.out.println("Range fill [1,4): " + Arrays.toString(rangeFill));
        
        // 10. copyOf() - Copies array with new length
        int[] original = {1, 2, 3, 4, 5};
        int[] copied = Arrays.copyOf(original, 3); // Copy first 3 elements
        System.out.println("Copy first 3 elements: " + Arrays.toString(copied));
        
        int[] extended = Arrays.copyOf(original, 8); // Extend array
        System.out.println("Extended copy: " + Arrays.toString(extended));
        
        // 11. copyOfRange() - Copies specified range
        int[] rangeCopy = Arrays.copyOfRange(original, 1, 4); // index 1 to 3
        System.out.println("Copy range [1,4): " + Arrays.toString(rangeCopy));
        
        // 12. toString() - Returns string representation
        String arrayString = Arrays.toString(original);
        System.out.println("Array as string: " + arrayString);
        
        // 13. deepToString() - For multidimensional arrays
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        String deepString = Arrays.deepToString(matrix);
        System.out.println("Multi-dimensional array: " + deepString);
        
        // 14. hashCode() - Returns hash code
        int hashCode = Arrays.hashCode(original);
        System.out.println("Hash code: " + hashCode);
        
        // 15. deepHashCode() - For multidimensional arrays
        int deepHashCode = Arrays.deepHashCode(matrix);
        System.out.println("Deep hash code: " + deepHashCode);
        
        // 16. asList() - Returns fixed-size list backed by array
        String[] fruits = {"Apple", "Banana", "Cherry"};
        java.util.List<String> fruitList = Arrays.asList(fruits);
        System.out.println("Array as list: " + fruitList);
        
        // 17. stream() - Returns sequential stream (Java 8+)
        int[] streamArray = {1, 2, 3, 4, 5};
        int sum = Arrays.stream(streamArray).sum();
        System.out.println("Sum using stream: " + sum);
        
        long count = Arrays.stream(streamArray).filter(n -> n > 2).count();
        System.out.println("Count numbers > 2: " + count);
        
        // 18. setAll() - Set all elements using generator function (Java 8+)
        int[] setAllArray = new int[5];
        Arrays.setAll(setAllArray, i -> i * i); // [0, 1, 4, 9, 16]
        System.out.println("setAll with squares: " + Arrays.toString(setAllArray));
        
        // 19. parallelSetAll() - Parallel version of setAll
        int[] parallelArray = new int[5];
        Arrays.parallelSetAll(parallelArray, i -> i * 2);
        System.out.println("parallelSetAll: " + Arrays.toString(parallelArray));
        
        // 20. parallelSort() - Parallel sorting (Java 8+)
        int[] bigArray = {5, 2, 8, 1, 9, 3, 7, 4, 6};
        Arrays.parallelSort(bigArray);
        System.out.println("Parallel sorted: " + Arrays.toString(bigArray));
        
        // 21. parallelPrefix() - Cumulative operation (Java 8+)
        int[] prefixArray = {1, 2, 3, 4, 5};
        Arrays.parallelPrefix(prefixArray, (a, b) -> a + b);
        System.out.println("Parallel prefix (sum): " + Arrays.toString(prefixArray));
        
        // 22. spliterator() - Returns Spliterator (Java 8+)
        var spliterator = Arrays.spliterator(original);
        System.out.println("Spliterator characteristics: " + spliterator.characteristics());
    }
}