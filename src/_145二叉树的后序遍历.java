import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145二叉树的后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>  list=new ArrayList<Integer>();
        /*
        if (root == null) {

            return list;
        }*/
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p=root;
        TreeNode r = null;
        while(!stack.isEmpty()||p!=null){

            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            TreeNode q=stack.peek();
            if (q.right!= null&&q.right!=r) {
                p=q.right;
            }
            else {
                stack.pop();
                r=q;
                System.out.println(q.val);
                list.add(q.val);
                p=null;
            }
        }
        return list;
    }
}
