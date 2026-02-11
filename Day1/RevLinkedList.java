
import java.util.Scanner;

public class RevLinkedList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) insert(sc.nextInt());
        reverse(); 
        display();   
    }

    
public static class Node{
    int data;
    Node next;

    Node(int n)
    {
        data = n;
        next = null;
        //prev = null; in dll
    }
}

    static Node head = null;
    static void insert(int n)
    {
        Node newNode = new Node(n);
        if(head==null) head = newNode;
        else
        {
            Node curr = head;
            while(curr.next!=null) curr = curr.next;
            curr.next = newNode;
            //newNode.prev = curr; in dll
        }
    }

    static void reverse()
    {
        Node curr = head;
        Node prev = null;
        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }

    static void display()
    {
        Node curr = head;
        while(curr!=null)
        {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }
}