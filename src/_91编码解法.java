public class _91编码解法 {
    public int numDecodings(String s) {
        if (s.length() == 0||s==null||s.charAt(0)-'0' == 0) {
            return 0;
        }
        if (s.length() == 1) {
             return 1;
        }
        int dp[]=new int[s.length()];
        dp[0]=1;

        if (Integer.valueOf(s.substring(0,2))<=26&&Integer.valueOf(s.substring(0,2))>0) {
            if (s.charAt(1)-'0'==0)dp[1]=1;
            else dp[1]=2;
        }
        else {
            if (s.charAt(1)-'0'==0) return 0;
            else dp[1]=1;
        }
        for (int i = 2; i <s.length() ; i++) {
            if (s.charAt(i-1)-'0' == 0) {
                if (s.charAt(i)-'0' == 0) {
                    return 0;
                }
                else {
                    dp[i]=dp[i-1];
                    continue;
                }
            }
            if (Integer.valueOf(s.substring(i-1,i+1))<=26&&Integer.valueOf(s.substring(i-1,i+1))>0) {
                if (s.charAt(i)-'0'==0)dp[i]=dp[i-2];
                else dp[i]=dp[i-1]+dp[i-2];
            }
            else {
                if (s.charAt(i)-'0'==0) return 0;
                else dp[i]=dp[i-1];
            }
        }
        return dp[s.length()-1];
    }

    public static void main(String[] args) {
        _91编码解法 a=new _91编码解法();
        System.out.println(a.numDecodings("100"));
    }
}
