import java.util.Scanner;

public class SortBitonicDll {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            insert(sc.nextInt());

        sortBitonic();
        display();
    }

    static class DoubleNode {
        int val;
        DoubleNode next;
        DoubleNode prev;

        DoubleNode(int x) {
            val = x;
            next = null;
            prev = null;
        }
    }

    static DoubleNode head = null;

    // Insert at end
    public static void insert(int n) {
        DoubleNode newNode = new DoubleNode(n);

        if (head == null) {
            head = newNode;
            return;
        }

        DoubleNode curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = newNode;
        newNode.prev = curr;
    }

    // Display forward
    public static void display() {
        DoubleNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    // Sort Bitonic DLL
    public static void sortBitonic() {
        if (head == null || head.next == null)
            return;

        DoubleNode curr = head;

        // Step 1: Find peak
        while (curr.next != null && curr.val <= curr.next.val)
            curr = curr.next;

        DoubleNode second = curr.next;
        curr.next = null;
        if (second != null)
            second.prev = null;

        // Step 2: Reverse second half
        second = reverse(second);

        // Step 3: Merge two sorted lists
        head = merge(head, second);
    }

    // Reverse DLL
    public static DoubleNode reverse(DoubleNode node) {
        DoubleNode temp = null;
        DoubleNode curr = node;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null)
            node = temp.prev;

        return node;
    }

    // Merge two sorted DLLs
    public static DoubleNode merge(DoubleNode first, DoubleNode second) {

        if (first == null)
            return second;
        if (second == null)
            return first;

        if (first.val < second.val) {
            first.next = merge(first.next, second);
            if (first.next != null)
                first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first, second.next);
            if (second.next != null)
                second.next.prev = second;
            second.prev = null;
            return second;
        }
    }


}
