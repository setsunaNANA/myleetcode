import java.util.HashSet;
import java.util.Set;

public class _142环形链表2 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode>  set=new HashSet<>();
        ListNode cur=head;
        while(cur!=null){
            if (set.contains(cur)) {
                return cur;
            }
            else set.add(cur);
            cur=cur.next;
        }
        return null;
    }
}
