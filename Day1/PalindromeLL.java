// # arrays fixed size, it should be static not dynamic
// # to overcome the disadvantage of size ll is used
// # insertion and deletion is easier in ll
// # array is a linear ds, ll is a linear ds with a collection of nodes in non contiguous memory locations.
// # linked list, doubly linked list, circular linked list
// # a node in single ll is divided into two, data and address

import java.util.Scanner;

public class PalindromeLL{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) insert(sc.nextInt());
        palindrome();   
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

    static void palindrome()
    {
        //finding mid node
        Node fast = head;
        Node slow = head;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node mid = slow;


        //optional (if odd length, skip mid node)
        if(fast!=null) slow = slow.next;

        //reversing the second half
        Node prev = null;
        Node curr = mid;

        while(curr!=null)
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        mid = prev;
        curr = head;

        //check if the reversed linkedlist (second half) is equal to the first half
        while(mid!=null)
        {
            if(curr.data!=mid.data)
            {
                System.out.println("Not a palindrome");
                return;
            }
            curr = curr.next;
            mid = mid.next;
        }
        System.out.println("Palindrome");
        }
}

