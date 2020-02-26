public class _213打家劫舍2 {
    public int rob(int[] nums) {
        int res=0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        }
        int []dp=new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0],nums[1]);
        for (int i = 2; i <nums.length-1 ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        res=dp[nums.length-2];

        dp[1]=nums[1];
        dp[2]=Math.max(dp[1],nums[2]);
        for (int i = 3; i <nums.length ; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        res=Math.max(res,dp[nums.length-1]);
        return res;
    }
}
