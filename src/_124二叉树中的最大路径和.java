public class _124二叉树中的最大路径和 {
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dp(root);
        return max;
    }
    int dp(TreeNode root){
        if (root == null) {
            return 0;
        }
        int l=dp(root.left);
        int r=dp(root.right);
        int maxlr=Math.max(l, r);
        int res=root.val+(maxlr>0?maxlr:0);
        int curmax=root.val+(l>0?l:0)+(r>0?r:0);
        max=Math.max(max,curmax);
         return res;
    }
}
