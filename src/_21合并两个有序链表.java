public class _21合并两个有序链表 {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1==null) {
                return l2;
            }
            else if (l2 == null) {
                return l1;
            }
            ListNode head=new ListNode(0);
            ListNode index3=head;
            ListNode index1=l1;
            ListNode index2=l2;
            while(index1!=null&&index2!=null){
                ListNode t;
                if (index1.val <= index2.val) {
                    t=index1;
                    index1=index1.next;
                }
                else {
                    t=index2;
                    index2=index2.next;
                }
                index3.next=t;
            }
            if (index1==null) {
                index3.next=index2;
            }
            else index3.next=index1;
            return  head.next;
        }


}
