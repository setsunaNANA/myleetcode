import java.util.ArrayList;
import java.util.List;

public class _228汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        if (nums.length==0) {
            return res;
        }
        if (nums.length==1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int start=0;
        int end=1;
        while (end<nums.length){
            while (end<nums.length&&nums[end]==nums[end-1]+1){
                end++;
            }
            if (end == start+1) {
                res.add(String.valueOf(nums[start]));
            }
            else {
                res.add(String.valueOf(nums[start])+"->"+ String.valueOf(nums[end-1]));
            }
            if(end<nums.length){
                start=end;
                end=end+1;
            }
        }
        if (start==nums.length-1) {
            res.add(String.valueOf(nums[start]));
        }

        return res;
    }
}
