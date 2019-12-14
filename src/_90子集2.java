import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90子集2 {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> tlist=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        help(0, nums);
        return res;
    }
    void help(int start,int nums[]){
        res.add(new ArrayList<>(tlist));
        for (int i = start; i <nums.length ; i++) {

            if (i>start&&nums[i] == nums[i-1]) {
                continue;
            }
            tlist.add(nums[i]);
            help(i+1, nums);
            tlist.remove(tlist.size()-1);
        }
    }
}
