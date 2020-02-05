public class _5最长回文子串 {
    public String longestPalindrome(String s) {
        if (s == null||s.equals("")) {
            return s;
        }
        int len=s.length();
        if (len==1) {
            return s;
        }
        int res[]=new int[3];
        res[0]=1;
        res[1]=0;
        res[2]=0;
        boolean dp[][]=new boolean[len][len];
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        for (int i = 0; i <len-1 ; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1]=true;
                res[0]=2;
                res[1]=i;
                res[2]=i+1;
            }
        }

        for (int step = 3; step <=len ; step++) {
            for (int start= 0; start+step-1<len ; start++) {
                    if (dp[start+1][start+step-2]&&s.charAt(start) == s.charAt(start+step-1)) {
                        dp[start][start+step-1]=true;
                      //  System.out.println(start+" "+(start+step-1));
                        if (step>res[0]) {
                            res[0]=step;
                            res[1]=start;
                            res[2]=start+step-1;
                          //  System.out.println( res[1]+" "+ res[2]);
                        }
                    }
            }
        }
       // System.out.println( res[1]+" "+ res[2]);
        return s.substring(res[1],res[2]+1);
    }
}
