public class _72编辑距离 {
    //word1 = "intention",
    //word2 = "execution"
    public int minDistance(String word1, String word2) {
        if (word1 == null||word1.length()==0) {
            return word2.length();
        }
        if (word2 == null||word2.length()==0) {
            return word1.length();
        }
        int [][]dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <=word2.length() ; i++) {
            dp[0][i]=i;
            System.out.printf("dp[%d][%d]=%d",0,i,dp[0][i]);
            System.out.println();
        }
        for (int i = 0; i <=word1.length() ; i++) {
            dp[i][0]=i;
            System.out.printf("dp[%d][%d]=%d",i,0,dp[i][0]);
            System.out.println();
        }
        for (int i = 1; i <=word1.length() ; i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];

                }
                else dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                System.out.printf("dp[%d][%d]=%d",i,j,dp[i][j]);
                System.out.println();
            }

        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
       String word1 = "horse", word2 = "ros";
       _72编辑距离 a=new _72编辑距离();
        System.out.println(a.minDistance(word1,word2));
    }

}
