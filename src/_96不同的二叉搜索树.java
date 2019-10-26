public class _96不同的二叉搜索树 {
    public int numTrees(int n) {
        if (n == 0||n==1) {
            return 1;
        }
        int [] dp=new int[n];
        dp[0]=1;

        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <i ; j++) {
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }
}
