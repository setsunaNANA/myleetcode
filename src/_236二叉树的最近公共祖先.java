import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _236二叉树的最近公共祖先 {

    private TreeNode c;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        mark(root, p, q);
        return c;
    }
    public boolean mark(TreeNode root, TreeNode p, TreeNode q){
        if (root==null)return false;
        int lflag=0;
        int rflag=0;
        int mit=0;
        if (this.mark(root.left, p, q))lflag=1;
        if (this.mark(root.right, p, q))rflag=1;
        if (root==p||root==q)mit=1;
        if(lflag+rflag+mit>=2)c=root;
        if(lflag+rflag+mit>0)return true;
        else return false;
    }
    public static void main(String[] args) {
        _236二叉树的最近公共祖先 a =new _236二叉树的最近公共祖先();
        TreeNode treeNode = new TreeNode(1);
        treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
        TreeNode p=treeNode.left.right=new TreeNode(4);
        TreeNode q=treeNode.right.right=new TreeNode(5);
        System.out.println(a.lowestCommonAncestor(treeNode,p,q).val);

    }

}
