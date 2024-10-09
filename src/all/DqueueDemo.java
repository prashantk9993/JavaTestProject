package all;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DqueueDemo {

        public static void main(String[] args) {
            Deque<String> q = new LinkedList<>();

            q.add("F");
            q.add("H");
            q.add("D");
            q.offer("C");
            q.offer("V");
            q.offer("U");

            q.addFirst("G");
            q.addLast("I");
            q.offerFirst("Y");
            q.offerLast("F");

            q.push("T");


            System.out.println("1 ::::::: "+q);
            System.out.println("2 ::::::: "+q.element());
            System.out.println("3 ::::::: "+q.peek());
            System.out.println("4 ::::::: "+q.poll());
            System.out.println("5 ::::::: "+q.remove());

            System.out.println("6 ::::::: "+q.getFirst());
            System.out.println("7 ::::::: "+q.getLast());

            System.out.println("8 ::::::: "+q.offerLast("S"));
            System.out.println("9 ::::::: "+q.offerFirst("V"));

            System.out.println("10 ::::::: "+q.pollLast());
            System.out.println("11 ::::::: "+q.pollFirst());

            System.out.println("12 ::::::: "+q.pop());
            System.out.println("13 ::::::: "+q);
        }
}
