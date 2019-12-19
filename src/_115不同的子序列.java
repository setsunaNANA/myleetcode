public class _115不同的子序列 {
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()) {
            return  0;
        }
        int  dp[][]=new int[s.length()+1][t.length()+1];
        for (int i = 1; i <=s.length() ; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i<=s.length() ; i++) {
            for (int j = 1; j <=t.length()&&j<=i ; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j]=dp[i][j-1]+dp[i-1][j-1];
                }
                else dp[i][j]=dp[i][j-1];
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        _115不同的子序列 a =new _115不同的子序列();
        System.out.println(a.numDistinct("rabbbit","rabbit"));
    }
}
