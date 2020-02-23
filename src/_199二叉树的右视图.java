import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _199二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if (root == null) {
            return res;
        }
        Set<Integer>hasright=new HashSet<>();
        rec(root, res, hasright,0);
        return res;
    }
    void rec (TreeNode root,List<Integer> res, Set<Integer>hasright,int deep){
        if (root == null) {
            return;
        }
        if (!hasright.contains(deep)) {
            res.add(root.val);
            hasright.add(deep);
        }
            rec(root.right, res,hasright,deep+1);
            rec(root.left, res,hasright,deep+1);
    }
}
