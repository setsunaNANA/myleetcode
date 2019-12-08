public class _82删除排序链表中的重复元素2 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode  pre=dummyhead;
        ListNode cur=head;
        while (cur!=null){
            if (cur.next!=null&&cur.val == cur.next.val) {
                int val=cur.val;
                while (cur!=null&&cur.val==val) {
                    cur=cur.next;
                }
                pre.next=cur;
                continue;
            }
            pre=cur;
            cur =cur.next;
        }
        return dummyhead.next;
    }
}
