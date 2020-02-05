import java.util.List;

public class _120三角形最小路径和 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len=triangle.size();
        /*if (len == 1) {
            return triangle.get(0).get(0);
        }*/
        int []dp=new int[len];
        for (int i = 0; i <len ; i++) {
            dp[i]=triangle.get(len-1).get(i);
        }
        for (int i = len-2; i >=0 ; i--) {
            for (int j = 0; j <=i ; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
