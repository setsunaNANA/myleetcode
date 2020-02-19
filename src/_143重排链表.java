public class _143重排链表 {
    public void reorderList(ListNode head) {
        int len=0;
        ListNode cur=head;
        while (cur!=null){
            len++;
            cur=cur.next;
        }

        subreorder(head,len);
    }

    ListNode subreorder(ListNode head,int len){
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            head.next=null;
            return head;
        }

        ListNode tail_pre=head;
        ListNode tail=tail_pre.next;
        for (int i = 0; i <len-2 ; i++) {
            tail_pre=tail_pre.next;
            tail=tail.next;
        }
        tail.next=subreorder(head.next, len-2);
        head.next=tail;
        return head;
    }

}
