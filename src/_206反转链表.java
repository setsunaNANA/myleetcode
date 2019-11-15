public class _206反转链表 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode cur=head.next;
        head.next=null;
        while (cur!=null){
            ListNode nextnode=cur.next;
            cur.next=dummyhead.next;
            dummyhead.next=cur;
            cur=nextnode;
        }
        return dummyhead.next;
    }
}
