import java.util.ArrayList;
import java.util.List;

public class _131分割回文串 {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> t_res=new ArrayList<>();
        if (s == null||s.length()==0||s.length()==1) {
            t_res.add(s);
            res.add(t_res);
            return res;
        }
        boolean [][]dp=dp_huiwen(s);
        backtrack(s, 0, t_res, res, dp);
        return res;

    }
//  aaba  a a b a

    void backtrack(String s,int start,List<String> t_res,List<List<String>> res, boolean [][]dp){
        if (start==s.length()) {
            res.add(new ArrayList<>(t_res));
            return;
        }

        for (int i = start; i <s.length() ; i++) {
            if ( dp[start][i]) {
                System.out.println(s.substring(start, i+1));
                t_res.add(s.substring(start, i+1));
                backtrack(s, i+1, t_res, res, dp);
                t_res.remove(t_res.size()-1);
            }
            else continue;
        }
    }
    boolean [][]dp_huiwen (String s){

        int len=s.length();
        boolean dp[][]=new boolean[len][len];
        if (len==1) {
            dp[0][0]=true;
            return dp;
        }
        for (int i = 0; i <len ; i++) {
            dp[i][i]=true;
        }
        for (int i = 0; i <len-1 ; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1]=true;
            }
        }
        for (int step = 3; step <=len ; step++) {
            for (int start= 0; start+step-1<len ; start++) {
                if (dp[start+1][start+step-2]&&s.charAt(start) == s.charAt(start+step-1)) {
                    dp[start][start+step-1]=true;
                }
            }
        }
        return dp;
    }

}
