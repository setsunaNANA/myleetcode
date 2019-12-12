import java.util.ArrayList;
import java.util.List;

public class _95不同的二叉搜索树 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res=new ArrayList<>();
        if (n == 0) {
            return res;
        }
        res=gen(1,n);
        return res;
    }
    private List<TreeNode> gen(int start,int end){
        List<TreeNode> res=new ArrayList<>();
        if (start>end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }
        for (int i = start; i <=end ; i++) {

            List<TreeNode> leftset=gen(start,i-1);
            List<TreeNode> rightset=gen(i+1,end);
            for (TreeNode left:leftset
                 ) {
                for (TreeNode right:rightset
                     ) {
                    TreeNode root=new TreeNode(i);
                    root.left=left;
                    root.right=right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
