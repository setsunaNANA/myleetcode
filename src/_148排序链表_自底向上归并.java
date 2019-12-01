
public class _148排序链表_自底向上归并 {
    public ListNode sortList(ListNode head) {

        if (head == null||head.next==null) {
            return head;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;

        ListNode p=head;
        int len=0;
        while (p!=null){
            len++;
            p=p.next;
        }
        for (int cutlen = 1; cutlen <len; cutlen*=2) {
            ListNode dummytail=dummyhead;
            ListNode cur=dummyhead.next;
            while (cur!=null){
                ListNode left=cur;
                ListNode right=cut(left,cutlen);
                cur=cut(right,cutlen);
                //System.out.println("left right"+left==null?9999:left.val+" "+right==null?9999:right.val);
                dummytail.next=merge(left, right);
                while (dummytail.next!=null){
                    dummytail=dummytail.next;
                }
            }

        }
        return dummyhead.next;
    }
    ListNode cut(ListNode head,int k){
        ListNode pre=new ListNode(0);
        ListNode cur =head;
        while (cur!=null&&k>0){
            pre=cur;
            cur=cur.next;
            k--;
        }
        pre.next=null;
        return cur;
    }
    ListNode merge(ListNode l1,ListNode l2){
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=l1;
        ListNode pre=dummyhead;
        while(l1!=null&&l2!=null){
            System.out.println(l1.val+" "+l2.val);
            if (l1.val>l2.val) {
                ListNode cur=l2;
                l2=l2.next;
                cur.next=pre.next;
                pre.next=cur;
            }
            else {
                l1=l1.next;
            }
            pre=pre.next;
        }
        if (l1 == null) {
            pre.next=l2;
        }
        return dummyhead.next;
    }
}
