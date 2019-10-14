import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15三数之和 {
    public List<List<Integer>> threeSum(int[] nums) {
        List <List<Integer>>res =new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i <nums.length-2 ; i++) {
            while(i>0&&nums[i]==nums[i-1])i++;
            for (int j = i+1; j <nums.length-1 ; j++) {
                while(nums[j]==nums[j-1])j++;
                for (int k = j+1; k <nums.length-2 ; k++) {
                    while (nums[k]==nums[k-1])k++;
                    if (nums[i] +nums[j]+nums[k]==0) {
                        res.add(new ArrayList<Integer>({nums[i],nums[j],nums[k]}));
                    }
                }
            }
        }
        return null;
    }
}
