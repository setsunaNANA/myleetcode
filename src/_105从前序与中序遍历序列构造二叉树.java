import java.util.HashMap;
import java.util.Map;

public class _105从前序与中序遍历序列构造二叉树 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null||preorder.length==0) {
            return null;
        }
        for (int i = 0; i <preorder.length ; i++) {
            map.put(preorder[i],i);
        }
        return help(0,inorder.length-1,inorder);
    }
    TreeNode help(int start,int end,int []inorder){
        System.out.println(inorder[start]+" "+inorder[end]);
        int index_split=min(start,end,inorder);
        TreeNode root=new TreeNode(inorder[index_split]);

        root.left=index_split ==start?null:help(start,index_split-1,inorder);
        root.right=index_split ==end?null:help(index_split+1,end,inorder);
        return root;
    }

    int min(int start,int end,int []inorder){
        int index_inorder=start;
        int index_preorder=map.get(inorder[start]);
        for (int i = start+1; i <=end ; i++) {
            if (index_preorder>map.get(inorder[i])) {
                index_inorder=i;
            }
        }
        return index_inorder;
    }
}
