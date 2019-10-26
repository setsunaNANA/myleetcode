public class _23合并k个有序链表 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null||lists.length==0) {
            return null;
        }
        return mergesort(lists,0,lists.length-1);
    }

    ListNode mergesort(ListNode[] lists,int start,int end){
        if (start==end) {
            return lists[start];
        }
        int mid=(start+end)/2;
        ListNode l1=mergesort(lists, start,mid);
        ListNode l2=mergesort(lists, mid+1,end);
        return mergeTwoLists(l1, l2);
    }

    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
