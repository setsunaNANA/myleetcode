public class _53最大子序和 {
    public int maxSubArray(int[] nums) {
        if (nums == null||nums.length==0) {
            return 0;
        }

        int []dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for (int i = 1; i <nums.length ; i++) {
            if (dp[i-1] > 0) {
                    dp[i]=dp[i-1]+nums[i];
                }
            else {
                dp[i]=nums[i];
            }
            if (dp[i] > max) {
                max=dp[i];
            }
            }
        return  max;
    }
}
