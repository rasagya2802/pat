import java.util.Scanner;

public class SortLinkedList {

    static class Node {
        int val;
        Node next;

        Node(int x) {
            val = x;
            next = null;
        }
    }

    static Node head = null;

    // Insert at end
    public static void insert(int n) {
        Node newNode = new Node(n);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = newNode;
    }

    // Display list
    public static void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Merge Sort Function
    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node mid = getMiddle(head);
        Node nextOfMid = mid.next;

        mid.next = null; // split list

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMid);

        return merge(left, right);
    }

    // Get middle using slow-fast pointer
    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted lists
    public static Node merge(Node left, Node right) {

        if (left == null)
            return right;
        if (right == null)
            return left;

        Node result;

        if (left.val <= right.val) {
            result = left;
            result.next = merge(left.next, right);
        } else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            insert(sc.nextInt());

        head = mergeSort(head);

        display();
    }
}
