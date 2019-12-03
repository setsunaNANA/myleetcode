public class _24两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        if (head==null||head.next == null) {
            return head;
        }
        ListNode pre=dummyhead;
        ListNode n1=dummyhead.next;
        ListNode n2=n1.next;
        while (n1!=null&&n2!=null){
            n1.next=n2.next;
            n2.next=n1;
            pre.next=n2;

            pre=n1;
            n1=n1.next;
            if (n1 != null) {
                n2=n1.next;
            }
        }
        return dummyhead.next;
    }
}
