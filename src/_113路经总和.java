import java.util.ArrayList;
import java.util.List;

public class _113路经总和 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> list=new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return res;
        }
        help(root,0,sum);
        return res;
    }
    private void help(TreeNode root,int cursum,int sum){
        cursum+=root.val;
        System.out.println(cursum);
        list.add(root.val);

        if (cursum == sum&&root.left==null&&root.right==null) {
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return;
        }
        if (root.left != null) {
            help(root.left,cursum,sum);
        }
        if (root.right != null) {
            help(root.right,cursum,sum);
        }
        list.remove(list.size()-1);
    }
}
