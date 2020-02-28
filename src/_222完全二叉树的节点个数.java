public class _222完全二叉树的节点个数 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left_height=height(root.left);
        int right_height=height(root.right);
        if (right_height ==left_height) {

            return countNodes(root.right) + (1<<left_height)-1+1;
        }
        else return countNodes(root.left) + (1<<right_height)-1+1;
    }

    int height(TreeNode root){


        int h=0;
        while (root != null){
            h++;
            root=root.left;
        }

        return h;
    }
}
