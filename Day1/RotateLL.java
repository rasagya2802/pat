// # arrays fixed size, it should be static not dynamic
// # to overcome the disadvantage of size ll is used
// # insertion and deletion is easier in ll
// # array is a linear ds, ll is a linear ds with a collection of nodes in non contiguous memory locations.
// # linked list, doubly linked list, circular linked list
// # a node in single ll is divided into two, data and address

import java.util.Scanner;

public class RotateLL{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++) insert(sc.nextInt());
        int k = sc.nextInt();
        roatate(k); 
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

    //logic
    static void roatate(int k)
    {
        int length = 1;
        Node last = head;
        while(last.next!=null) 
            {
                last = last.next;
                length++;
            }
        last.next = head;
        k = k%length;

        Node curr = head;
        for(int i=0; i<length-k-1; i++) curr=curr.next;

        head = curr.next;
        curr.next = null;
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

