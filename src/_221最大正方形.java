import java.time.chrono.MinguoChronology;

public class _221最大正方形 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null||matrix.length==0||matrix[0].length==0||matrix[0]==null) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int dp[][] = new int[row + 1][col + 1];
        int record[][][] = new int[row + 1][col + 1][2];
        int max = 0;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    record[i][j][0] = record[i - 1][j][0] + 1;
                    record[i][j][1] = record[i][j - 1][1] + 1;
                    int len=Math.min(Math.min(record[i][j][0], record[i][j][1]),dp[i-1][j-1]+1);
                    dp[i][j]= Math.min(dp[i-1][j-1]+1,len);
                    max = Math.max(max,  dp[i][j] *  dp[i][j]);
                }
            }
        }
        return max;
    }
}
