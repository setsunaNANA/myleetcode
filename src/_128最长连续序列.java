import java.util.Arrays;

public class _128最长连续序列 {
    public int longestConsecutive(int[] nums) {
        if (nums == null||nums.length==0) {
            return 0;
        }
        Arrays.sort(nums);
        int max=1;
        int curlen=1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] == nums[i-1]+1) {
                curlen++;
            }
            else if(nums[i] == nums[i-1]) {
                continue;
            }
            else {
                max=Math.max(max, curlen);
                curlen=1;
            }
        }
        max=Math.max(max, curlen);
        return max;
    }
}
