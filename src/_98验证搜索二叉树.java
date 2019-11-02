public class _98验证搜索二叉树 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l=false;
        boolean r=false;
        if (root.left!=null) {
            if (root.val>root.left.val) {

            l=isValidBST(root.left)&&root.val>max(root.left);
            }
        }
        else l=true;
        if (root.right!=null) {
            if (root.val<root.right.val) {
                r = isValidBST(root.right)&&root.val<min(root.right);
            }
        }
        else r=true;
        return l&&r;
    }
    int min(TreeNode root){
        TreeNode p=root;
        while (p.left!=null){
            p=p.left;
        }
        return p.val;
    }
    int max(TreeNode root){
        TreeNode p=root;
        while (p.right!=null){
            p=p.right;
        }
        return p.val;
    }
}
