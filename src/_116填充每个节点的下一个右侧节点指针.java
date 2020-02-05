import java.util.LinkedList;
import java.util.Queue;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class _116填充每个节点的下一个右侧节点指针 {
    /*public Node connect(Node root) {
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
                queue.add(cur.right);
                width+=2;
            }
            width--;
            if (width == 0) {
                cur.next=null;
                //width=queue.size();
            }
            else {
                cur.next=queue.peek();
            }

        }
        return root;
    }*/
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node left=root.left;
        Node right=root.right;
        while (left!=null){
            left.next=right;
            left=left.right;
            right=right.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }



}
