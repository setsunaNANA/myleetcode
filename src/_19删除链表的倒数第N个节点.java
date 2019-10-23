import java.util.ArrayList;
import java.util.List;

public class _19删除链表的倒数第N个节点 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode kpre =head;
        ListNode kpast =kpre;
        for (int i = 0; i <n ; i++) {
            kpast=kpast.next;
            if (kpast == null) {
                return head.next;
            }
        }
        while (kpast.next!=null){
            kpast=kpast.next;
            kpre=kpre.next;
        }
        kpre.next=kpre.next.next;
        return head;
    }
}
