package all;

public class TestNegativeSizeArray {
    public static void main(String[] args) {
        try {
            int[] arr = new int[-5];
        } catch (NegativeArraySizeException e) {
            System.out.println("Exception 1");
        } catch (RuntimeException e) {
            System.out.println("Exception 2");
        }
    }
}