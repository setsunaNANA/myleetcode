import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List <List<Integer>>res =new ArrayList<>();
        Arrays.sort(nums);
        List <Integer> tres=new ArrayList<>();
        for (int i = 0; i <nums.length-2 ; i++) {
            int sum=0-nums[i];
            if (i>0&&nums[i]==nums[i-1])continue;
            if (nums[i]>0) {
                break;
            }//-4 -1 -1 0 1 2
            int high=i+1;int low=nums.length-1;
            while(high<low){
                if (nums[high]+nums[low]==sum) {
                    while(high<low&&nums[high]==nums[high+1])high++;
                    while(high<low&&nums[low]==nums[low-1])low--;
                    tres.add(nums[i]);
                    tres.add(nums[high]);
                    tres.add(nums[low]);
                    res.add(new ArrayList<Integer>(tres));
                    tres.clear();
                }
                if (nums[high]+nums[low]<sum) {
                    high++;
                }
                else low--;
            }

        }
        return res;
    }
}
