public class _114二叉树展开为链表 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode currightnode=root.right;
        root.right=root.left;
        root.left=null;
        while (root.right!=null){
            root=root.right;
        }
        root.right=currightnode;
    }


}
