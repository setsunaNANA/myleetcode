public class _188买卖股票的最佳时机IV_二维矩阵压缩 {
    public int maxProfit(int k, int[] prices) {
        //int res=0;
        int len=prices.length;
        if (len == 0) {
            return 0;
        }
        int dp[][]=new int[k+1][2];

        if (k*2>len) {
            return maxProfit_Infinit_k(prices);
        }

        for (int count = 0; count <=k ; count++) {
            dp[count][0]=0;
            dp[count][1]=Integer.MIN_VALUE;
        }
// 1 2 4
       /* for (int day = 1; day <=len ; day++) {
            System.out.println("第"+day+"天");
            for (int count = k; count >=1 ; count--) {
                dp[day][count][1]=Math.max(dp[day-1][count][1],dp[day-1][count-1][0]-prices[day-1]);
                dp[day][count][0]=Math.max(dp[day-1][count][0],dp[day-1][count][1]+prices[day-1]);
                System.out.println(""+dp[day][count][0]+" "+dp[day][count][1]);
            }
        }*/
        for (int day = 1; day <=len ; day++) {
            //二维数组相当于把所有天数的信息都压缩到一个数组dp 每次循环都更新保存为第1天第2天......
            System.out.println("第"+day+"天");
            for (int count = k; count >=1 ; count--) {
                // 每次循环开始时 dp保存的都是上天的信息
                //每次计算dp[count][0]dp[count][1]都要用到上天的信息（dp[day-1]）
                //若count从1到k循环则
                // 负责保存原来三维数组时（dp[day-1]dp[count][0]和dp[day-1]dp[count][1]）
                // 的 dp[count][0]和 dp[count][1]会被覆盖成这天最新的dp[day]dp[count][0]和dp[day]dp[count][1]
                //所以只能倒着从k到1循环 保证再计算当天的信息时不会覆盖以后要用到的上天的信息
                dp[count][0]=Math.max(dp[count][0],dp[count][1]+prices[day-1]);
                dp[count][1]=Math.max(dp[count][1],dp[count-1][0]-prices[day-1]);
            }
        }

        return dp[k][0];
    }
    /*public int maxProfit_Infinit_k(int[] prices){
        int len=prices.length;
        int dp[][]=new int[len+1][2];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        for (int i = 1; i <=len ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1]=Math.max(dp[i-1][i],dp[i-1][0]-prices[i-1]);
        }
        return dp[len][0];
    }*/
    public int maxProfit_Infinit_k(int[] prices){
        int len=prices.length;
        int dp_i_0=0;
        int dp_i_1=Integer.MIN_VALUE;

        for (int i = 1; i <=len ; i++) {
            int dp_i减1_0=dp_i_0;//若不保存上一天的信息  先计算的dp_i_0就会把上一天的dp_i_0覆盖掉
            dp_i_0=Math.max(dp_i减1_0, dp_i_1+prices[i-1]);
            dp_i_1=Math.max(dp_i_1, dp_i减1_0-prices[i-1]);
        }
        return dp_i_0;
    }
}
