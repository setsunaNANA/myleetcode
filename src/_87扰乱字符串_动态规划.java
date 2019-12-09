public class _87扰乱字符串_动态规划 {

    public boolean isScramble(String s1, String s2) {
        boolean [][][]dp=new boolean[s1.length()+1][s1.length()][s1.length()];
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }
        /*for (int i = 0; i <s1.length() ; i++) {
            dp[1][i][i]=(s1.charAt(i)==s2.charAt(i));
        }*/
        for (int len = 1; len <s1.length() ; len++) {
            for (int i = 0; i<s1.length()-len;i++) {
                for (int j = 0; j <s1.length()-len ; j++) {
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    }
                    else {
                        for (int k = 1; k <len ; k++) {
                            if (dp[k][i][j]&&dp[len-k][i+k][j+k]||dp[k][i][j+len-k]&&dp[len-k][i+k][j]) {
                                dp[len][i][j]=true;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[s1.length()][0][0];
    }

}

