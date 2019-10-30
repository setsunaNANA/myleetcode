import java.util.*;

public class _56合并区间 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null||intervals.length==0||intervals.length==1) {
            return intervals;
        }
        Comparator<int []> comparator = (a,b)->(a[0]-b[0]);
        Arrays.sort(intervals,comparator);
        //Arrays.sort(intervals,(a,b)->(a[0]-b[0]));
        List<int[]> list=  new LinkedList<>(Arrays.asList(intervals));
        for (int i = 1; i <list.size() ; ) {
            if (list.get(i-1)[1] >= list.get(i)[0]) {
                if (list.get(i-1)[1] < list.get(i)[1]) {
                    list.set(i-1,new int[]{list.get(i-1)[0],list.get(i)[1]});
                }
                list.remove(i);
            }
            else i++;
        }

        int[][] res=new int[list.size()][];
        for (int i = 0; i <list.size() ; i++) {
            res[i]=list.get(i);
        }
    return res;
    }

    public static void main(String[] args) {
        _56合并区间 a=new _56合并区间();
        a.merge(new int[][]{{1,2},{2,3},{6,7}});
    }
}
