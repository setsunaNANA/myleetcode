import java.util.LinkedList;
import java.util.List;
/*
 扫描数组
 找到新区间在原区间集合中的的范围  loc[0][0]~ loc[1][0]
 找到新区间端点的数  left~right
 删除原区间数组中 下标为 loc[0][0]~ loc[1][0]的区间
 在loc[0][0]插入新区间（left,right）
 */
class _57插入区间 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null||intervals.length==0) {
            return new int[][]{newInterval};
        }

        List<int []> res=new LinkedList<>();
        int left=newInterval[0],right=newInterval[1];
        for (int [] cur:intervals
        ) {
            res.add(cur);
        }
        if (newInterval[0]>intervals[intervals.length-1][1]) {
            res.add(newInterval);
            int [][]ress=new int[res.size()][2];
            for (int i = 0; i <ress.length ; i++) {
                ress[i]=res.get(i);
            }
            return ress;
        }
        if (newInterval[1]<intervals[0][0]) {
            res.add(0,newInterval);
            int [][]ress=new int[res.size()][2];
            for (int i = 0; i <ress.length ; i++) {
                ress[i]=res.get(i);
            }
            return ress;
        }
        int [][] loc=new int[2][2];
        boolean flag1=false;
        boolean flag2=false;
        for (int i = 0; (!flag1)&&i <intervals.length ; i++) {
            for (int j = 0; j <2 ; j++) {
                if (intervals[i][j]>=newInterval[0]) {
                    loc[0][0]=i;
                    loc[0][1]=j;
                    System.out.println(i);
                    flag1=true;
                    break;
                }
            }
        }
        for (int i = intervals.length-1; (!flag2)&&i >=0 ; i--) {
            for (int j = 1; j >=0 ; j--) {
                if (intervals[i][j]<=newInterval[1]) {
                    loc[1][0]=i;
                    loc[1][1]=j;
                    System.out.println(i);
                    flag2=true;
                    break;
                }
            }
        }
        System.out.println(loc[0][0]+" "+loc[1][0]);

        if (loc[0][1]==1) {
            left=intervals[loc[0][0]][0];
        }
        if (loc[1][1]==0) {
            right=intervals[loc[1][0]][1];
        }
        System.out.println(left+" "+right);
        for (int i = loc[0][0]; i <=loc[1][0] ; i++) {
            System.out.println(i);
            res.remove(loc[0][0]);
        }
        res.add(loc[0][0], new int[]{left,right});
        int [][]ress=new int[res.size()][2];
        for (int i = 0; i <ress.length ; i++) {
            ress[i]=res.get(i);
        }
        return ress;
    }

    public static void main(String[] args) {
        _57插入区间 a=new _57插入区间();
        int [][] qq=new int[][]{{1,3},{6,9}};
        int []ww=new int[]{2,5};
        a.insert(qq, ww);
    }

}