public class _61旋转链表 {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }
        ListNode tail = head;
        int length=1;
        while(tail.next!=null){
            length++;
            tail=tail.next;
        }
        k=k%length;
        if (k == 0) {
            return head;
        }
        ListNode kpre =head;
        ListNode kpast =kpre;
        for (int i = 0; i <k ; i++) {
            kpast=kpast.next;
        }
        while (kpast!=tail){
            kpast=kpast.next;
            kpre=kpre.next;
        }

        //ListNode newhead= kpre.next!=null?kpre.next:head;
        ListNode newhead= kpre.next;
                kpre.next=null;
        tail.next=head;
        return newhead;
    }
}
