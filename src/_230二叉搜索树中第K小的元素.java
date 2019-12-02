public class _230二叉搜索树中第K小的元素 {
    int count=0;
    int res=0;
    public int kthSmallest(TreeNode root, int k) {
        help(root,k);
        return res;
    }
    void help(TreeNode root,int k){
        if (root == null||count==k) {
            return ;
        }
        help(root.left,k);
        if (++count == k) {
            res=root.val;
        }
        help(root.right,k);
    }
}
