import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _210课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int res[]=new int[numCourses];
        int res_index=0;
        HashMap<Integer, Integer> in_degree=new HashMap<>();
        HashMap<Integer, List> map=new HashMap<>();
        for (int i = 0; i <numCourses ; i++) {
            in_degree.put(i, 0);
        }
        for (int []cur:prerequisites
             ) {
            in_degree.put(cur[0],in_degree.get(cur[0])+1);

            if (map.containsKey(cur[1])) {
                map.get(cur[1]).add(cur[0]);
            }
            else map.put(cur[1],new ArrayList(){{add(cur[0]);}});
        }
        for (Map.Entry<Integer,Integer> entry_in_degree:in_degree.entrySet()
             ) {
            System.out.println(entry_in_degree.getKey()+" "+entry_in_degree.getValue());
        }
        for (int i = 0; i <numCourses ; i++) {
            for (Map.Entry<Integer,Integer> entry_in_degree:in_degree.entrySet()
            ) {
                if (entry_in_degree.getValue() == 0) {
                    int cur=entry_in_degree.getKey();
                    List <Integer>tlist=map.get(cur);
                    if (tlist != null) {
                        for (int index:tlist
                        ) {
                            in_degree.put(index, in_degree.get(index)-1);
                        }
                    }
                    in_degree.remove(cur);
                    res[res_index]=cur;
                    res_index++;
                    break;
                }
            }
        }

        if (in_degree.isEmpty()) {
            return res;
        }
        else return new int[0];
    }
}
