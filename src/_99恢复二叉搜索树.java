import java.util.Stack;

public class _99恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode res_1=null;
        TreeNode res_1_post=null;
        TreeNode res_2=null;
        TreeNode pre=new TreeNode(Integer.MIN_VALUE);
        TreeNode post=null;
        Stack<TreeNode> stack=new Stack<>();

        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            post=root;
            root=root.right;
            if (pre.val > post.val) {
                if (res_1 == null) {
                    res_1=pre;
                    res_1_post=post;
                }
                else {
                    res_2=post;
                    int t=res_1.val;
                    res_1.val=res_2.val;
                    res_2.val=t;
                    return;
                }
            }
            pre=post;
        }
        //执行到这一步说明是两个遍历顺序上相邻的被交换了 所以res_2=null  如 1 2 3 4 5-> 1 3 2 4 5   只需要交换res_1 3 和res_1_post 2
            int t=res_1.val;
            res_1.val=res_1_post.val;
            res_1_post.val=t;

    }
}
