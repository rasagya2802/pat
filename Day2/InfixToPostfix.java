package Day2;

import java.util.Scanner;
import java.util.Stack;
//postfix is also known as reversepolish

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String output = "";

        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(Character.isDigit(ch)) output = output + ch;
            else if(ch=='(') stack.push(ch);
            else if(ch==')') 
            {
                while(!stack.isEmpty()&&stack.peek()!='(') output = output + stack.pop();
        
                stack.pop();
            } 
            else
            {
                while(!stack.isEmpty()&&prec(ch)<=prec(stack.peek())) output = output + stack.pop();

                stack.push(ch);
            }
            
        }
        while(!stack.isEmpty()) output = output+stack.pop();
        System.out.println(output);
    }

    public static int prec(char ch){
        if(ch=='+'||ch=='-') return 1;
        if(ch=='/'||ch=='*') return 2;
        if(ch=='^') return 3;
        return 0;
    }
}
