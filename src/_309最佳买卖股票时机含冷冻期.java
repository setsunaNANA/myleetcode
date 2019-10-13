import java.util.FormatFlagsConversionMismatchException;

public class _309最佳买卖股票时机含冷冻期 {
    public int maxProfit(int[] prices, int cool) {
        int k=cool+1;
        if (prices.length == 0) {
            return 0;
        }
        int [][]dp=new int[prices.length][2];
        for (int i = 0; i <prices.length; i++) {
            if(i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
                continue;
            }
            if(i-k<0){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
                continue;
            }
                dp[i][0]= Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]= Math.max(dp[i-1][1],dp[i-k][0]-prices[i]);
        }
        return dp[prices.length-1][0];
    }
    public static void main(String[] args) {
        int a[]={2,12,2,20,7,7,9,10,1,9};
        _309最佳买卖股票时机含冷冻期 b=new _309最佳买卖股票时机含冷冻期();
        System.out.println(b.maxProfit(a,4));
    }
}

