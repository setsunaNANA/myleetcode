import java.util.ArrayList;
import java.util.List;

public class _78子集 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> dp=new ArrayList<List<Integer>>();
        if (nums == null||nums.length==0) {
            return new ArrayList<List<Integer>>();
        }
        dp.add(new ArrayList<Integer>());
        for (int i = 0; i <nums.length ; i++) {
            int len=dp.size();
            for (int j=0;j<len;j++) {
                List<Integer> tlist=new ArrayList<>(dp.get(j));
                tlist.add(nums[i]);
                dp.add(tlist);
            }
        }
        return dp;

    }

    public static void main(String[] args) {
        _78子集 a=new _78子集();
        a.subsets(new int[]{-1,1,2});
    }


}
