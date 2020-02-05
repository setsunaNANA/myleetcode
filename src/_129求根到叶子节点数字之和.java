import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _129求根到叶子节点数字之和 {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        Stack<Integer> stack=new Stack<>();
        help(root, stack);
        return sum;
    }
    void help(TreeNode root,Stack<Integer>stack){
        stack.add(root.val);
        if (root.left != null) {
            help(root.left,stack);
        }
        if (root.right != null) {
            help(root.right,stack);
        }
        if (root.left == null&&root.right==null) {
            List<Integer> list=new ArrayList<>(stack);
            int num=0;
            for (int cur:list
            ) {
                System.out.print(cur+" ");
                num=num*10+cur;
            }
            sum+=num;
            System.out.println("num="+num);
            System.out.println("sum="+sum);
        }
        stack.pop();
    }
}
