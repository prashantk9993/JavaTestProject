package all;
import java.util.ArrayList;
import java.util.stream.Stream;

class StreamDemo4 {
    public static void main(String[] args) {

        ArrayList<String> s1 = new ArrayList<>(100);
        s1.add(null);

        System.out.println(" Original List ::: "+s1);

        // A list of double values.
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(7.0);
        myList.add(18.0);
        myList.add(10.0);
        myList.add(24.0);
        myList.add(17.0);
        myList.add(5.0);

        System.out.println(" Original List ::: "+myList);
        // Map the square root of the elements in myList to a new stream.
        Stream<Double> sqrRootStream = myList.stream().map( x -> Math.sqrt(x));
        sqrRootStream.forEach(x-> System.out.print(x+ " "));
    }

}