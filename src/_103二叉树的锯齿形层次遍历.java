import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _103二叉树的锯齿形层次遍历 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Stack<TreeNode> stack1=new Stack<>();
        Stack<TreeNode> stack2=new Stack<>();
        if (root == null) {
            return res;
        }
        stack1.add(root);
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            List<Integer> tlist=new ArrayList<>();
            if (!stack1.isEmpty()) {
                while (!stack1.isEmpty()){
                    TreeNode cur=stack1.pop();
                    tlist.add(cur.val);
                    if (cur.left!= null) {
                        stack2.add(cur.left);
                    }
                    if (cur.right != null) {
                        stack2.add(cur.right);
                    }
                }
            }
            else {
                while (!stack2.isEmpty()){
                    TreeNode cur=stack2.pop();
                    tlist.add(cur.val);
                    if (cur.right!= null) {
                        stack1.add(cur.right);
                    }
                    if (cur.left != null) {
                        stack1.add(cur.left);
                    }
                }
            }
            res.add(tlist);
        }
        return res;
    }
}
