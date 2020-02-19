import java.io.DataInputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _138复制带随机指针的链表 {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        Map<Node,Node> map=new HashMap<>();
        if (head == null) {
            return null;
        }
        Node res=new Node(head.val);
        map.put(head,res);
        if (head.next != null) {
            res.next= Dfs(head.next, map);
        }
        if (head.random != null) {
            res.random= Dfs(head.random, map);
        }
        return res;
    }
    Node Dfs(Node cur,Map<Node,Node> map){
        if (map.containsKey(cur)) {
            return map.get(cur);
        }
        else {
            Node copy_cur=new Node(cur.val);
            map.put(cur,copy_cur);
            if (cur.next != null) {
                copy_cur.next= Dfs(cur.next, map);
            }
            if (cur.random != null) {
                copy_cur.random= Dfs(cur.random, map);
            }
            return copy_cur;
        }
    }
}
