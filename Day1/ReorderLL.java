
//leetcode style
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class ReorderLL {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode prev = null;        
        while(slow!=null)
        {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode currfirst = head;
        ListNode currsecond = prev;
        while(currsecond.next!=null)
        {
            ListNode temp1 = currfirst.next;
            ListNode temp2 = currsecond.next;
            
            currfirst.next = currsecond;
            currsecond.next = temp1;

            currfirst = temp1;
            currsecond = temp2;
        }
    }
}
