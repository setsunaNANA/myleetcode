public class _337打家劫舍3 {
    public int rob(TreeNode root) {
        int []res= help(root);
        return Math.max(res[0],res[1]);
    }
    int[] help(TreeNode root){
        if (root == null) {
            return new int[2];
        }
        int []res=new int[2];
        int []lres=help(root.left);
        int []rres=help(root.left);
        int lnoroot=lres[0];
        int rnoroot=rres[0];
        int lhasroot=lres[1];
        int rhasroot=rres[1];
        res[0]=Math.max(lhasroot,lnoroot)+Math.max(rnoroot,rhasroot);
        res[1]=root.val+lnoroot+rnoroot;
        System.out.println(root.val);
        System.out.println("noroot"+" "+res[0]);
        System.out.println("hasroot"+" "+res[1]);
        return res;
    }
}
