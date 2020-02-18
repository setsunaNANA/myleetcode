public class _25K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyhead=new ListNode(0);
            dummyhead.next=head;
            ListNode head_pre=dummyhead;
            ListNode tail_next=head;
            ListNode cur=tail_next;
            while (cur!=null){
                for (int i = 0; i <k ; i++) {
                    if (cur == null) {
                        return dummyhead.next;
                    }
                    cur=cur.next;
                }
                tail_next=cur;
               /* if (tail_next != null) {
                    System.out.println(head_pre.val+"~"+tail_next.val);
                }
                else System.out.println(head_pre.val+"~null");*/
                head_pre=reverse(head_pre, tail_next);
                ListNode test=dummyhead.next;
            }
        return dummyhead.next;
    }

    ListNode reverse(ListNode head_pre,ListNode tail_next){

        ListNode head=head_pre.next;
        ListNode cur=head;
        ListNode cur_next=cur.next;

        while (cur!=tail_next){
            cur.next=head_pre.next;
            head_pre.next=cur;
            cur=cur_next;
            if (cur == null) {
                break;
            }
            cur_next=cur.next;
        }
        head.next=tail_next;
        return head;
    }
}
