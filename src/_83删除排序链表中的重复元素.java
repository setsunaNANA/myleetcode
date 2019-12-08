public class _83删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur=head;
        while (cur!=null){
            while (cur.next!=null&&cur.val == cur.next.val) {
                cur.next=cur.next.next;
            }
            cur =cur.next;
        }
        return head;
    }
}
