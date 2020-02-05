import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _132分割回文串2 {
  /*   int min=Integer.MAX_VALUE;
   public int minCut(String s) {
        if (s == null||s.length()==0||s.length()==1) {
            return 0;
        }
        min=s.length()-1;
        boolean [][]dp=dp_huiwen(s);
        backtrack(s, 0, 0, dp);
        return min;

    }
//  aaba  a a b a

    void backtrack(String s,int start, int cur_count,boolean [][]dp){
        System.out.println("cur_count="+cur_count);
        if (dp[start][s.length()-1]) {
            if (cur_count<min) {
                min= cur_count;
                System.out.println("min="+min);
            }
            return;
        }
        if (dp[start][s.length()-1]||start==s.length()) {
            if (cur_count-1<min) {
                min= cur_count-1;
                System.out.println("min="+min);
            }
            return;
        }
        if (cur_count==min) {
            return;
        }
        for (int i = start; i <s.length() ; i++) {
            if ( dp[start][i]) {
                System.out.println(s.substring(start, i+1));
                backtrack(s, i+1, cur_count+1, dp);
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
    }*/
  public int minCut(String s){
      if (s == null||s.length()==0) {
          return 0;
      }
      int len=s.length();
      boolean [][]is_huiwen=dp_huiwen(s);
      int []dp=new int[len];
      dp[0]=0;
      for (int i = 1; i <len ; i++) {
          if (is_huiwen[0][i]) {
              dp[i]=0;
              continue;
          }
          int cur_min=dp[i-1]+1;
          for (int j = i-1; j>=0 ; j--) {
              if (is_huiwen[j][i]) {
                    cur_min= Math.min(cur_min, dp[j-1]+1);
              }
          }
          dp[i]=cur_min;
      }
    return dp[len-1];
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
