import java.util.LinkedList;
import java.util.Queue;

public class _111二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int width=1;
        int deep=0;
        while (!queue.isEmpty()){
            deep++;
            while (width!=0){
                TreeNode cur=queue.poll();
                width--;
                if (cur.left == null&&cur.right==null) {
                    return deep;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            } width=queue.size();

        }
        return deep;
    }
}
