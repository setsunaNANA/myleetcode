import javax.print.attribute.standard.MediaSize;

public class _148排序链表_顺序快排 {
    ListNode bigdummyhead=new ListNode(0);
    public ListNode sortList(ListNode head) {
        bigdummyhead.next=head;
        ListNode tail=head;
        while (tail.next!=null){
            tail=tail.next;
        }
        quicksort(head, tail);
        return bigdummyhead.next;
    }
    void quicksort(ListNode head,ListNode tail){
        System.out.println(head.val+" "+tail.val);
        if (head == tail) {
            return;
        }
        ListNode [] res=partition(head, tail);
        quicksort(res[0], res[1]);
        quicksort(res[1], res[2]);
    }

    ListNode[] partition(ListNode head,ListNode tail ){
        boolean flaghead=false;
        boolean flagtail=false;
        if (bigdummyhead.next==head) {
            flaghead=true;
        }
        if (head == tail) {
            return new ListNode[]{head,head,head};
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode smaller=head;
        ListNode bigger=head.next;
        ListNode pre1=dummyhead;
        ListNode pre2=head;
        while (bigger!=tail.next){
            if (bigger.val<smaller.val) {
                smaller=smaller.next;
                pre1=pre1.next;

                ListNode biggernext= bigger.next;
                pre1.next=bigger;
                bigger.next=smaller.next;
                pre2.next=smaller;
                smaller.next=biggernext;

                smaller=pre1.next;
                bigger=pre2.next;
            }
            bigger=bigger.next;
            pre2=pre2.next;
        }

        ListNode smallernext=smaller.next;
        smaller.next=head.next;
        dummyhead.next=smaller;
        pre1.next=head;
        head.next=smallernext;
        if (flaghead) {
            bigdummyhead.next=dummyhead.next;
        }
        return new ListNode[]{dummyhead.next,head,pre2};
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        _148排序链表_顺序快排 a= new _148排序链表_顺序快排();
        a.sortList(head);
    }
}
