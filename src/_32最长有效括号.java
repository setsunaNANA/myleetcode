import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class _32最长有效括号 {
    public int longestValidParentheses(String s) {
        if (s == null||s.length()==0) {
            return 0;
        }
        int max=0;
        int []dp=new int[s.length()];
        dp[0]=0;
        for (int i = 1; i <s.length() ; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i-1) == '(') {
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }
                else  {
                    if (i - dp[i - 1] > 0 &&s.charAt(i-dp[i-1]-1) == '(') {
                        dp[i]=(i-dp[i-1]-2>0?dp[i-dp[i-1]-2]:0)+dp[i-1]+2;
                    }
                }
                max=Math.max(max, dp[i]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        _32最长有效括号 a=new _32最长有效括号();
        System.out.println(a.longestValidParentheses("()(()"));
    }
}
