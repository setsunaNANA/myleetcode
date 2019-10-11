public class _112路经总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return occursum(root, 0, sum);
    }
    boolean occursum(TreeNode root, int tsum, int sum){
        tsum+=root.val;
        boolean l=false;
        boolean r =false;
        if (root.left!= null) {
            l= occursum(root.left, tsum, sum);
        }
        if (root.right!= null) {
           r= occursum(root.right, tsum, sum);
        }
        if (root.left==null&&root.right==null) {
             if (tsum == sum) {
               return true;
           }
          else {
             return false;
          }
        }
        return l||r;
    }
}
