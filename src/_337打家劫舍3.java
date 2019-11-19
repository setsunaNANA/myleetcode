public class _337打家劫舍3 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lmax=rob(root.left);
        int rmax=rob(root.right);
       // int lrmax=Math.max(lmax,rmax);
        return Math.max(lmax+rmax,root.val);
    }
}
