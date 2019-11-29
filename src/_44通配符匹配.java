public class _44通配符匹配 {
    public boolean isMatch(String s, String p) {
        if (s == null||s.length()==0) {
            if (p == null||p.length()==0) {
                return true;
            }
        }

        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 0; i <=s.length() ; i++) {
            for (int j = 1; j <=p.length() ; j++) {
                if (i == 0) {
                    if (dp[0][j-1]&&p.charAt(j-1)=='*') {
                        dp[0][j]=true;
                    }
                    continue;
                }
                if (dp[i-1][j-1]) {
                    if (p.charAt(j-1) == s.charAt(i-1)||p.charAt(j-1)=='?'||p.charAt(j-1)=='*') {
                        dp[i][j]=true;
                    }
                }
                if (dp[i-1][j]||dp[i][j-1]) {
                    if (p.charAt(j-1)=='*') {
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
