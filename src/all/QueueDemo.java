package all;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();

        q.add("F");
        q.add("H");
        q.add("D");
        q.offer("C");
        q.offer("V");
        q.offer("U");

        System.out.println("1 ::::::: "+q);
        System.out.println("2 ::::::: "+q.element());
        System.out.println("3 ::::::: "+q.peek());
        System.out.println("4 ::::::: "+q.poll());
        System.out.println("5 ::::::: "+q.remove());
        System.out.println("6 ::::::: "+q);
    }
}
