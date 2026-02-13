package Day3;
import java.util.ArrayDeque;
import java.util.Scanner;
public class Queue1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            int n = sc.nextInt();
            for(int i=0; i<n; i++) queue.offer(sc.nextInt());
            System.out.println(queue.peek() +" " + queue.size() + " " + queue.isEmpty() + " " +  queue.poll());
        }
}
