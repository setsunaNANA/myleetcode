

public class _160相交链表 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null||headB==null) {
            return null;
        }
        ListNode a=headA;
        ListNode b=headB;
        while (a!=null&&b!=null){
            a=a.next;
            b=b.next;
        }
        if (a == null) {
            while (b!=null){
                b=b.next;
                headB=headB.next;
            }
        }
        else {
            while (a!=null){
                a=a.next;
                headA=headA.next;
            }
        }
        while (headA!=headB){
            headA=headA.next;
            headB=headB.next;
        }
        return headA;
    }
}
