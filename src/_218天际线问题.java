import java.awt.*;
import java.util.*;
import java.util.List;

public class _218天际线问题 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res=new LinkedList<>();
        if (buildings.length == 0) {
            return res;
        }
        int [][]xy=new int[buildings.length*2][2];

        TreeMap<Integer,Integer> height=new TreeMap<>();
        height.put(0,0);

        for (int i = 0; i <buildings.length ; i++) {
            xy[i*2][0]=buildings[i][0];
            xy[i*2][1]=buildings[i][2];//左端点
            xy[i*2+1][0]=buildings[i][1];
            xy[i*2+1][1]=-buildings[i][2];//号表示右端点
        }
        Arrays.sort(xy, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if ( o1[0]-o2[0]==0) {//当横坐标相等时
                   return o2[1]-o1[1];
                }
                else return o1[0]-o2[0];//横坐标靠前的先计算
            }
        });

        for (int []index:xy
             ) {
            int x=index[0];
            int y=index[1];
            int cur_maxheight=height.lastKey();
            int count;
            if (y>0) {
                count=height.getOrDefault(y,0);
            }
            else {
                count=height.getOrDefault(-y,0);
            }
            if (y>0) {
                height.put(y,count+1);
            }
            else {
                if (count == 1) {
                    height.remove(-y);
                }
                else {
                    height.put(-y,count-1);
                }
            }
            if (cur_maxheight != height.lastKey()) {
                res.add(new ArrayList<Integer>(){
                    {
                        add(x);
                        add(height.lastKey());
                    }
                });
            }
        }
        return res;
    }


}
