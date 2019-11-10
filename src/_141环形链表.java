public class _141环形链表 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){ ;
            if (fast.next==null) {
                return false;
            }
            fast=fast.next.next;
            slow=slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
