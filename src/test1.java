import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class test1 {
    static final int N=100000;
    static final int n=100;

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<N;i++) {
            list.add(i);
        }
        Collections.shuffle(list);

        Collection<Integer> list1=new ArrayList<Integer>(list);
        System.out.println("ArrayList 添加时长"+addtime(list1)+"，搜索时长"+searchtime(list1)+"，删除时间"+removetime(list1));

        //linkedlist为什么不用写<>
        Collection<Integer> list2=new LinkedList(list);
        System.out.println("LinkedList 添加时长"+addtime(list2)+"，搜索时长"+searchtime(list2)+"，删除时间"+removetime(list2));

        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<N;i++) {
            stack.add(i);
        }
        Collections.shuffle(stack);
        System.out.println("Stack 添加时长"+addtime(stack)+"，搜索时长"+searchtime(stack)+"，删除时间"+removetime(stack));

        Collection<Integer> hashset=new HashSet<Integer>(list);
        System.out.println("HashSet 添加时长"+addtime(hashset)+"，搜索时长"+searchtime(hashset)+"，删除时间"+removetime(hashset));

        Collection<Integer> treeset=new TreeSet<Integer>(list);
        System.out.println("TreeSet 添加时长"+addtime(treeset)+"，搜索时长"+searchtime(treeset)+"，删除时间"+removetime(treeset));

        Collection<Integer> linkedhashset=new LinkedHashSet(list);
        System.out.println("LinkedHashSet 添加时长"+addtime(linkedhashset)+"，搜索时长"+searchtime(linkedhashset)+"，删除时间"+removetime(linkedhashset));

        Map<Integer, Integer>hashMap=new HashMap<Integer, Integer>();
        for(int i=0;i<N;i++) {
            hashMap.put(i,i);
        }
        System.out.println("HashMap 添加时长"+addtime2(hashMap)+"，搜索时长"+searchtime2(hashMap)+"，删除时间"+removetime2(hashMap));

        Map<Integer,Integer> linkedHashMap=new LinkedHashMap<Integer, Integer>(hashMap);
        System.out.println("LinkedHashMap 添加时长"+addtime2(linkedHashMap)+"，搜索时长"+searchtime2(linkedHashMap)+"，删除时间"+removetime2(linkedHashMap));

        Map<Integer,Integer> TreeMap=new TreeMap<Integer, Integer>(hashMap);
        System.out.println("TreeMap 添加时长"+addtime2(TreeMap)+"，搜索时长"+searchtime2(TreeMap)+"，删除时间"+removetime2(TreeMap));
    }
    public static long addtime(Collection<Integer> c) {
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            //这里要加int
            c.add((int)(Math.random()*N));
        }
        return System.nanoTime()-starttime;
    }
    public static long addtime2(Map<Integer, Integer> c) {
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            //这里要加int
            c.put((int)(Math.random()*N),(int)(Math.random()*N));
        }
        return System.nanoTime()-starttime;
    }
    public static long searchtime(Collection<Integer> c) {
//        long starttime=System.currentTimeMillis();
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            //这里要加int
            c.contains((int)(Math.random()*N));
        }
//        return System.currentTimeMillis()-starttime;
        return System.nanoTime()-starttime;
    }
    public static long searchtime2(Map<Integer, Integer> c) {
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            c.containsKey((int)(Math.random()*N));
        }
        return System.nanoTime()-starttime;
    }
    public static long removetime(Collection<Integer> c) {
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            c.remove((int)(Math.random()*N));
        }
        return System.nanoTime()-starttime;
    }
    public static long removetime2(Map<Integer, Integer> c) {
        long starttime=System.nanoTime();
        for(int i=0;i<n;i++) {
            c.remove((int)(Math.random()*N));
        }
        return System.nanoTime()-starttime;
    }
}
