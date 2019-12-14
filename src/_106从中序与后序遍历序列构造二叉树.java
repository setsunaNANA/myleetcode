import java.util.HashMap;

public class _106从中序与后序遍历序列构造二叉树 {
    int []post;
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        post=postorder;
        return help(0, inorder.length-1, 0, postorder.length-1);
    }
    private TreeNode help(int instart,int inend,int poststart,int postend){
        if (inend<instart||postend<poststart) {
            return null;
        }
        int rootval=post[postend];
        int split=map.get(rootval);
        TreeNode root=new TreeNode(rootval);
        root.left=help(instart, split-1, poststart, poststart+split-instart-1);
        root.right=help(split+1,inend,poststart+split-instart,postend-1);
        return root;
    }
}
