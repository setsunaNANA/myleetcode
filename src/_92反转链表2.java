public class _92反转链表2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode fakehead = dummyhead;
        ListNode faketail = dummyhead;
        for (int i = 0;i<m-1  ; i++) {
            fakehead=fakehead.next;
        }
        for (int i = 0;i<=n  ; i++) {
            faketail=faketail.next;
        }
        ListNode cur=fakehead.next;
        fakehead.next=faketail;
        for (int i = 0; i <n-m+1 ; i++) {
            ListNode vernode=cur;
            cur=cur.next;
            vernode.next=fakehead.next;
            fakehead.next=vernode;
        }
        return dummyhead.next;
    }
}
