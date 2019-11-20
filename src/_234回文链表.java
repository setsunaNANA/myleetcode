public class _234回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode cur=slow;
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            cur=slow;
            slow=slow.next;
            cur.next=dummyhead.next;
            dummyhead.next=cur;
        }
        if (fast!=null) {
            slow=slow.next;
        }
        while(slow!=null){
            if (cur.val != slow.val) {
                return false;
            }
            cur=cur.next;
            slow=slow.next;
        }
        return true;
    }
}
