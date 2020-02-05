import java.util.LinkedList;
import java.util.Queue;


public class _117填充每个节点的下一个右侧节点指针2 {
    /**/public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int width=1;
        while(!queue.isEmpty()){
            Node cur=queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
            width--;
            if (width == 0) {
                cur.next=null;
                width=queue.size();
            }
            else {
                cur.next=queue.peek();
            }

        }
        return root;
    }
}