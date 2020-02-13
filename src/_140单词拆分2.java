import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _140单词拆分2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>  res=new ArrayList<>();
        Set<String> String_set=new HashSet<>();
        Set<Integer> Length_set=new HashSet<>();
        for (String t:wordDict
             ) {
            String_set.add(t);
            Length_set.add(t.length());
        }

        boolean []dp=dp(s, wordDict);

        backtrack(s, String_set, Length_set, "", res, dp);
        return res;
    }

    public boolean []dp(String s, List<String> wordDict) {
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
        return dp;
    }
    void backtrack(String s,Set<String> String_set,Set<Integer> Length_set,String cur_res,List<String> res,boolean[]dp){
        System.out.println("s="+s+"  cur_res="+cur_res);
        if (!dp[s.length()]) {
            return;
        }
        if (s.equals("")) {
            System.out.println(cur_res);
            res.add(cur_res.substring(0, cur_res.length()-1));
            return;
        }
        for (int len:Length_set
             ) {
            if (s.length()>=len) {
                String t=s.substring(s.length()-len,s.length());
                if (String_set.contains(t)) {
                    backtrack(s.substring(0,s.length()-len), String_set, Length_set, t+" "+cur_res,res,dp);
                }
            }
        }
        return;
    }
}
