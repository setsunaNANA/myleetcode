import java.util.HashSet;
import java.util.Set;

public class _207课程表 {
    Set <Integer>set=new HashSet<>();
    Set <Integer>kaitou=new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i <numCourses ; i++) {
           // set.clear();
            if (kaitou.contains(i)) {
                continue;
            }
            if ((!help(i, prerequisites))) {
                return false;
            }
        }
        return true;
    }
    boolean help(int i,int[][] prerequisites){
        if (set.contains(i)) {
            return false;
        }
        set.add(i);
        kaitou.add(i);
        for (int[]cur:prerequisites
        ) {
            if (cur[0] == i) {
                System.out.println(cur[0]+" "+cur[1]);
                if(!help(cur[1],prerequisites)){
                    set.remove(i);
                    return false;
                }
            }
        }
        set.remove(i);
        return true;
    }

    public static void main(String[] args) {
        _207课程表 a=new _207课程表();
        System.out.println(a.canFinish(3, new int[][]{{0,1},{0,2},{1,2}}));
    }
}
