import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _102二叉树的层次遍历 {
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> tlist=new ArrayList<>();
        if (root == null) {
            return res;
        }
        queue.add(root);
        tlist.add(root.val);
        res.add(new ArrayList<>(tlist));
        tlist.clear();
        int count=1;
        System.out.printf("这一层有1个结点");
        System.out.println();
        while (!queue.isEmpty()){
            TreeNode peek=queue.poll();
            if (peek.left != null) {
                queue.add(peek.left);
                tlist.add(peek.left.val);
                System.out.printf("把%d放入队列",peek.left.val);
                System.out.println();
            }
            if (peek.right != null) {
                queue.add(peek.right);
                tlist.add(peek.right.val);
                System.out.printf("把%d放入队列",peek.right.val);
                System.out.println();
            }
            count--;
            if (count == 0) {
                res.add(new ArrayList<>(tlist));
                System.out.println(tlist);
                tlist.clear();
                count=queue.size();
                System.out.printf("这一层有%d个结点",count);
                System.out.println();
            }
        }
        res.remove(res.size()-1);
        return res;
    }*/
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        if (root == null) {
            return ansList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ansList.add(ans);
        }
        return ansList;
    }

}
