import java.util.Arrays;

public class _322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount==0)return 0;
        int len=coins.length;
        int [][]dp=new int [len][amount+1];
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j <amount+1 ; j++) {
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i <=amount ; i++) {
            if (i%coins[0]==0) {
                dp[0][i]=i/coins[0];
            }
        }
        for (int i = 1; i <len ; i++) {
            for (int curmount = 0; curmount <=amount ; curmount++) {
                for (int k = 0; k <=curmount/coins[i] ; k++) {
                    if (curmount-k*coins[i]>=0&&dp[i-1][curmount-k*coins[i]]!=Integer.MAX_VALUE) {
                        dp[i][curmount]=Math.min(dp[i-1][curmount-k*coins[i]]+k,dp[i][curmount]);
                        System.out.printf("dp[%d][%d]=",i,curmount);
                    }
                }
            }
        }
        if (dp[len-1][amount]==Integer.MAX_VALUE) {
            return -1;
        }
        return dp[len-1][amount];
    }

    public static void main(String[] args) {
        _322零钱兑换 a=new _322零钱兑换();
        System.out.println(a.coinChange(new int[]{186,419,83,408
        },6249));
    }
}
