public class _235二叉搜索树的最近公共祖先 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        System.out.println(root.val);
        if (root.val<=p.val&&root.val>=q.val||root.val>=p.val&&root.val<=q.val) {
            return root;
        }
        if (root.val>p.val&&root.val>q.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else {
            return lowestCommonAncestor(root.right,p,q);
        }
    }


}
