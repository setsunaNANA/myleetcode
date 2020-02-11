public class _101对称二叉树 {
   /* public boolean isSymmetric(TreeNode root) {
        if (root == null||root.left==null&&root.right==null) {
            return true;
        }
        else return help(root.left,root.right);
    }
    boolean help(TreeNode left,TreeNode right){
        if (left==null&&right==null) {
            return true;
        }
        if (left==null||right==null||right.val!=left.val) {
            return false;
        }
        return help(left.left, right.right)&&help(left.right, right.left);
    }*/
   public boolean isSymmetric(TreeNode root) {
       if (root == null) {
           return true;
       }
       return help(root, root);
   }
   boolean help(TreeNode left,TreeNode right){
       if (left == null||right==null) {
           if (left == null&&right==null) {
               return true;
           }
           else return false;
       }
       if (left.val == right.val) {
           return help(left.left, right.right)&&help(left.right, right.left);
       }
       else return false;
   }
}