public class _300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        else if (nums.length == 1) {
            return 1;
        }
        int []dp=new int[nums.length];
        dp[0]= 1;
        int realmax=0;
        for (int i = 1; i <nums.length ; i++) {
            dp[i] = 1;
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
                dp[i] = max;
                realmax=Math.max(realmax, max);
            }
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int[] a={10,9,2,5,3,7,101,18};
        _300最长上升子序列 b= new _300最长上升子序列();
        System.out.println(b.lengthOfLIS(a));
    }
}
