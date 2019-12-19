public class _97交错字符串 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null||s1.length()==0) {
            if (s2.equals(s3)) {
                return true;
            }
            else return false;
        }
        if (s2 == null||s2.length()==0) {
            if (s1.equals(s3)) {
                return true;
            }
            else return false;
        }
        if (s1.length()+s2.length() != s3.length()) {
            return false;
        }
        int len1=s1.length();
        int len2=s2.length();
        boolean dp[][]=new boolean[len1+1][len2+1];
        dp[0][0]=true;
        for (int i = 0; i <=len1; i++) {
            for (int j = 0; j <=len2 ; j++) {
                if (i!=0&&dp[i-1][j]) {
                    if (s1.charAt(i-1)==s3.charAt(i-1+j)) {
                        dp[i][j]=true;
                    }
                }
                if (j!=0&&dp[i][j-1]) {
                    if (s2.charAt(j-1)==s3.charAt(i-1+j)) {
                        dp[i][j]=true;
                    }
                }
            }
        }
        return dp[len1][len2];
    }
}
