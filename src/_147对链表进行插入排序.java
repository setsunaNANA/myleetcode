public class _147对链表进行插入排序 {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        /*
         dm -> 5 -> 1 -> 2 -> 3
        * */
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode tail_sorted=dummyhead.next;//目前有序链表尾部
        while (tail_sorted.next!=null){
            ListNode cur_sort=tail_sorted.next;//该考虑的元素

            System.out.println("待排序的是"+cur_sort.val);
            if (cur_sort.val >= tail_sorted.val) {
                tail_sorted=tail_sorted.next;//若大于有序链表尾部 直接加入有序序列
                continue;
            }
            tail_sorted.next=tail_sorted.next.next;
            ListNode index=dummyhead;
            while (index.next.val<cur_sort.val){
                index=index.next;
            }
            System.out.println("插入地点是"+cur_sort.val);
            cur_sort.next=index.next;
            index.next=cur_sort;
        }
        return dummyhead.next;
    }
}
