package _146LRU缓存机制;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
直接继承linkedhashmao实现
public class LRUCache extends LinkedHashMap<Integer,Integer> {
    int capacity;
    public LRUCache(int capacity) {
        super(10,0.75f,true);
        this.capacity=capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key,value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return this.size()>capacity;
    }


}*/
class LRUCache {
    public static void main(String[] args) {

    }
    HashMap <Integer,Node>map;
    int capacity;
    Node dummyhead;
    Node dummytoil;
    public LRUCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<Integer,Node>();
        dummyhead=new Node(0,0);
        dummytoil=new Node(0,0);
        dummyhead.next=dummytoil;
        dummyhead.pre=null;
        dummytoil.pre=dummyhead;
        dummytoil.next=null;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node cur=map.get(key);
            remove(cur);

            add(cur);
            return cur.vaule;
        }
        else return -1;
    }

    public void put(int key, int value) {
        Node cur=new Node(key,value);
        if (map.containsKey(key)) {
                remove(map.get(key));
        }
        map.put(key, cur);
        add(cur);

        if (map.size() > capacity) {
           // System.out.println(dummyhead.next.key);
            map.remove(dummyhead.next.key);
            remove(dummyhead.next);
        }
    }

    void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }

    void add(Node node){
        dummytoil.pre.next=node;
        node.pre=dummytoil.pre;
        dummytoil.pre=node;
        node.next=dummytoil;
    }
}

class Node{
    int key;
    int vaule;
    Node pre,next;
    Node(int key,int value){
        this.key=key;
        this.vaule=value;
        pre=null;
        next=null;
    }

}