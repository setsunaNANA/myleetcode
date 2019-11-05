
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class test {
    static final int N=10000000;
    public static void main(String[] args) {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        for (int i=0;i<N;i++) {
            arrayList.add(i);
        }
        Collections.shuffle(arrayList);

        System.out.println("ArrayList:");
        time(arrayList);

        LinkedList<Integer> linkedList=new LinkedList<Integer>(arrayList);
        System.out.println("LinkedList:");
        time(linkedList);

    }
    public static void time(List<Integer> c) {
        long starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.add(0, i);
        }
        System.out.println("在第一个元素前增加元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.add(i);
        }
        System.out.println("在最后一个元素后增加元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.add((int)Math.random()*N,i);
        }
        System.out.println("在其他位置增加元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.contains((int)Math.random()*N);
        }
        System.out.println("查找元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.remove(0);
        }
        System.out.println("删除第一个元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            //c.remove(N-1);
            c.remove(c.size()-1);
        }
        System.out.println("删除最后一个元素："+(System.currentTimeMillis()-starttime));

        starttime=System.currentTimeMillis();
        for(int i=0;i<100;i++) {
            c.remove((int)Math.random()*N);
        }
        System.out.println("删除其他位置元素："+(System.currentTimeMillis()-starttime));
    }


}
