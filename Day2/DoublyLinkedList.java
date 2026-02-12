package Day2;
import java.util.Scanner;

public class DoublyLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) insert(sc.nextInt());
        displayRev();
    }

    public static class DoubleNode{
        int val;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(int x)
        {
            val = x;
            next = null;
            prev = null;
        }        
    }
    
    static DoubleNode head = null; 
    public static void insert(int n){
        DoubleNode newNode = new DoubleNode(n);
        if(head==null) head = newNode;
        else
        {
            DoubleNode curr = head;
        while(curr.next!=null)
            curr = curr.next;

        curr.next = newNode;
        newNode.prev = curr;
        }
    }

    public static void displayRev(){
        DoubleNode curr = head;
        while(curr.next!=null) curr = curr.next;

        while(curr!=null)
        {
        System.out.print(curr.val + " ");
        curr = curr.prev;
        }
    }
}
