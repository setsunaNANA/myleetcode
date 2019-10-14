import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _94二叉树中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(cur!=null||!stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            TreeNode q=stack.pop();
            list.add(q.val);
            if (q.right != null) {
                cur=q.right;
            }
        }
        return list;
    }
}
