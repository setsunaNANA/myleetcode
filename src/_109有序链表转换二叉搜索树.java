public class _109有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyhead=new ListNode(0);
        dummyhead.next=head;
        ListNode slowpre=dummyhead;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slowpre=slowpre.next;
        }
        ListNode rootnode=slowpre.next;
        slowpre.next=null;
        TreeNode root=new TreeNode(rootnode.val);
        root.left=sortedListToBST(dummyhead.next);
        root.right=sortedListToBST(rootnode.next);
        return root;
    }
}
