public class _86分割链表 {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode loc=dummyhead;
        while (loc.next!=null){
            if (loc.next.val>=x) {
                break;
            }
            loc=loc.next;
        }

        if(loc==null)return head;
        System.out.println(loc.val);
        ListNode pre=loc;
        ListNode cur=pre.next;
        while (cur!=null){
            if (cur.val<x) {
                pre.next=cur.next;
                cur.next=loc.next;
                loc.next=cur;
                loc=loc.next;
                cur=pre.next;

            }
            else {
                pre=cur;
                cur=cur.next;
            }
            System.out.println(cur.val);
        }
        return dummyhead.next;
    }
}
