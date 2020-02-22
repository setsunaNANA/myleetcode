import java.util.Stack;

public class _173二叉搜索树迭代器 {
    class BSTIterator {
        Stack<TreeNode> stack=new Stack<>();
        public BSTIterator(TreeNode root) {
            TreeNode cur=root;
            while (cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode next=stack.pop();
            TreeNode cur=next.right;
            while (cur != null) {
                stack.push(cur);
                cur=cur.left;
            }
            return next.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if (stack.isEmpty()) {
                return false;
            }
            else return true;
        }
    }
}
