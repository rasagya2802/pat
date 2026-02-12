package Day2;
import java.util.Scanner;
import java.util.Stack;

public class Stack1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for(int i=0; i<n; i++) stack.push(sc.nextInt());
        System.out.println(stack.peek() +" " + stack.size() + " " + stack.isEmpty() + " " +  stack.pop());
    }
}
