import java.util.LinkedList;
import java.util.Queue;

public class _226翻转二叉树 {
    /*public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode t=root.left;
        root.left=root.right;
        root.right=t;
        return root;
    }*/
    public TreeNode invertTree(TreeNode root){
        if ( root== null) {
            return null;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur=queue.poll();
            TreeNode t=cur.left;
            cur.left=cur.right;
            cur.right=t;
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);

        }
        return root;
    }
}
