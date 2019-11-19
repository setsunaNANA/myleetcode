public class _322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        int len=coins.length;
        int [][]dp=new int [amount][len];
        for (int i = 0; i <len ; i++) {
            int price=coins[0];
            for (int j = 0; j <amount ; j++) {
                if (j%price==0) {
                    dp[j][i]=j/price;
                }
            }
        }
    }
}
