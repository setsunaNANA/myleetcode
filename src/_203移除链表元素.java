public class _203移除链表元素 {
        public ListNode removeElements(ListNode head, int val) {
            if (head == null) {
                return head;
            }
            ListNode dummyhead=new ListNode(0);
            dummyhead.next=head;
            ListNode pre=dummyhead;
            while (pre.next!=null){
                if (pre.next.val == val) {
                    pre.next=pre.next.next;
                }
                else pre=pre.next;
            }
            return dummyhead.next;
        }
}
