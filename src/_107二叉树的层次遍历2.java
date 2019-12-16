import java.util.*;

public class _107二叉树的层次遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int width=1;
        while (!queue.isEmpty()){
            List<Integer> tlist=new ArrayList<>();
            while (width!=0){
                TreeNode cur=queue.poll();
                tlist.add(cur.val);
                width--;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            width=queue.size();
            res.add(tlist);
        }
        Collections.reverse(res);
        return res;
    }
}
