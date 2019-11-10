import java.util.List;

public class _139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean [] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length() ; i++) {
            for (String ts:wordDict
                 ) {
                int len=ts.length();
                dp[i]=(i-len>=0)&&dp[i-len]&&(ts.equals(s.substring(i-len,i)));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
