import java.util.ArrayList;
import java.util.List;

public class _152乘积最大子序列 {
    public int maxProduct(int[] nums) {
        if (nums == null||nums.length==0) {
            return 0;
        }
        int max=nums[0];
        int []dpmax=new int[nums.length+1];
        dpmax[0]=1;
        int []dpmin=new int[nums.length+1];
        dpmin[0]=1;
        for (int i = 1; i <=nums.length ; i++) {
            dpmax[i]=Math.max(nums[i-1],Math.max(nums[i-1]*dpmax[i-1],nums[i-1]*dpmin[i-1]));
            dpmin[i]=Math.min(nums[i-1],Math.min(nums[i-1]*dpmax[i-1],nums[i-1]*dpmin[i-1]));
            max=Math.max(max, dpmax[i]);
        }
        return max;
    }
}
