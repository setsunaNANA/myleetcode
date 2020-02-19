import javax.print.attribute.standard.NumberOfDocuments;
import java.util.*;


public class _133克隆图 {
    private class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    /*public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer,Node> map=new HashMap<>();
        return Dfs(node, map);
    }
    Node Dfs(Node node, Map<Integer,Node> map){
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node cur_node=new Node(node.val);
        map.put(cur_node.val, cur_node);
        for (Node next_node:node.neighbors
             ) {
            cur_node.neighbors.add(Dfs(next_node, map));
        }
        return cur_node;
    }*/
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer,Node> map=new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        queue.add(node);
        Node res=new Node(node.val);
        map.put(node.val, res);
        while(!queue.isEmpty()){
            Node cur_node=queue.poll();
            for (Node temp:cur_node.neighbors
                 ) {
                if (!map.containsKey(temp.val)) {
                    map.put(temp.val, new Node(temp.val));
                    queue.offer(temp);
                }
                map.get(cur_node.val).neighbors.add(map.get(temp.val));
            }
        }
        return res;
    }
}

