public class _174地下城游戏 {
    public int calculateMinimumHP(int[][] dungeon) {
        //这道题应该逆向思维 用dp[i][j]表示从i j出发到右下角所需最少血量
        int height=dungeon.length;
        int width=dungeon[0].length;
        int []dp=new int [width];
        for (int i = width-1; i >=0 ; i--) {
            dp[i]=i+1==width?1-dungeon[height-1][i]:Math.max(1-dungeon[height-1][i],dp[i+1]-dungeon[height-1][i]);
        }
        for (int j = height-2; j>=0 ; j--) {
            for (int i= width-1; i >=0 ; i--) {
                dp[i]=i+1==width?Math.max(1-dungeon[j][i],dp[i]-dungeon[j][i]):
                        Math.min(Math.max(1-dungeon[j][i],dp[i+1]-dungeon[j][i]),Math.max(1-dungeon[j][i], dp[i]-dungeon[j][i]));
            }
        }
        return dp[0]<=0?1:dp[0];
    }
}
