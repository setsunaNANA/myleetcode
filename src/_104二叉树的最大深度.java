public class _104二叉树的最大深度 {
    public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        else {
            int curheight =Math.max(maxDepth(root.left), maxDepth(root.right))+1;
            return curheight;
        }

    }
}
