public class _101对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null||root.left==null&&root.right==null) {
            return true;
        }
        else return help(root.left,root.right);
    }
    boolean help(TreeNode left,TreeNode right){
        if (left==null&&right==null) {
            return true;
        }
        if (left==null||right==null||right.val!=left.val) {
            return false;
        }
        return help(left.left, right.right)&&help(left.right, right.left);
    }
}