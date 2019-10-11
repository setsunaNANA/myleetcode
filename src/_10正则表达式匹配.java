public class _10正则表达式匹配 {
    /*public boolean isMatch(String s, String p) {
        boolean [][]dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*'&&dp[0][i-1]) {
                dp[0][i+1]=true;
            }
        }
        for (int i = 1; i <=s.length() ; i++) {
            int I=i-1;
            for (int j = 1; j <=p.length() ; j++) {
                int J=j-1;
                if (s.charAt(I) == p.charAt(J)|| p.charAt(J)=='.') {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if (p.charAt(J) == '*') {
                    if (J>=1&&(s.charAt(I) == p.charAt(J-1)||p.charAt(J-1)=='.')) {
                        dp[i][j]=dp[i-1][j-1];
                    }
                    if (J>=2&&(s.charAt(I) == p.charAt(J-2)||p.charAt(J-1)=='.')) {
                        dp[i][j]=dp[i][j-2];
                    }
                    if(J>=1&&dp[i][j-1]){
                        dp[i][j]=dp[i][j-1];
                    }
                    if(J>=2&&dp[i][j-2]){
                        dp[i][j]=dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }*/

    public boolean isMatch(String s, String p){

        boolean [][]dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        //预处理
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*'&&dp[0][i-1]) {
                dp[0][i+1]=true;
            }
        }

        for (int i = 1; i <=s.length() ; i++) {
            int I=i-1;
            for (int j = 1; j <=p.length() ; j++) {
                int J=j-1;
                if (s.charAt(I) == p.charAt(J)||p.charAt(J)=='.') {
                    dp[i][j]=dp[i-1][j-1];
                }
                else if (p.charAt(J) == '*') {
                    if (J>=1&&dp[i][j-1]) {
                        dp[i][j]=dp[i][j-1];
                        continue;
                    }
                    if (J>=2&&dp[i][j-2]) {
                        dp[i][j]=dp[i][j-2];
                        continue;
                    }
                    if (J>=1&&(s.charAt(I)==p.charAt(J-1)||p.charAt(J-1)=='.')&&dp[i-1][j]) {
                        dp[i][j]=dp[i-1][j];
                        continue;
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
        _10正则表达式匹配 a= new _10正则表达式匹配();
        String s="aab";
        String p="c*a*b";
        System.out.println(a.isMatch(s, p));
    }
}
