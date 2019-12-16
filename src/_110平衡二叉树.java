public class _110平衡二叉树 {
    public boolean isBalanced(TreeNode root) {
        int deep= depth(root);
        return deep==-1?false:true;
    }
    private int depth(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftdepth=depth(root.left);
        int rightdepth=depth(root.right);
        if (rightdepth == -1||leftdepth==-1||Math.abs(leftdepth-rightdepth)>1) {
            return -1;
        }
        return Math.max(leftdepth,rightdepth)+1;
    }
}
