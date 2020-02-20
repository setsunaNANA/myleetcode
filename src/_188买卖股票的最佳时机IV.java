public class _188买卖股票的最佳时机IV {
    public int maxProfit(int k, int[] prices) {
        //int res=0;
        int len=prices.length;
        if (len == 0) {
            return 0;
        }
        int dp[][][]=new int[len+1][k+1][2];
        if (k*2>len) {
            k=len/2;
        }
        for (int count = 0; count <=k ; count++) {
            dp[0][count][0]=0;
            dp[0][count][1]=Integer.MIN_VALUE;
        }

        for (int day = 0; day <len ; day++) {
            dp[day][0][0]=0;
            dp[day][0][1]=Integer.MIN_VALUE;
        }
// 1 2 4
        for (int day = 1; day <=len ; day++) {
            System.out.println("第"+day+"天");
            for (int count = 1; count <=k ; count++) {
                dp[day][count][1]=Math.max(dp[day-1][count][1],dp[day-1][count-1][0]-prices[day-1]);
                dp[day][count][0]=Math.max(dp[day-1][count][0],dp[day-1][count][1]+prices[day-1]);
                System.out.println(""+dp[day][count][0]+" "+dp[day][count][1]);
            }
        }

       /* for (int day = 0; day <=len ; day++) {
            for (int count = 0; count <=k ; count++) {
                System.out.println(day+"天"+count+"次交易：不持股 "+dp[count][day][0]+"  持股:"+dp[count][day][1]+"  ");
                //  res=Math.max(res,  dp[day][count][0]);
            }
            System.out.println();
        }*/

        return dp[len][k][0];
    }


}
