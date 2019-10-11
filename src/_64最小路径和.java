public class _64最小路径和 {
    public int minPathSum(int[][] grid) {

        int ilen=grid.length;
        int jlen=grid[0].length;
        if (ilen == 0) {
            return 0;
        }
        int [][] min=new int[ilen][jlen];

        min[0][0]=grid[0][0];
        for (int i = 0; i < ilen; i++) {
            for (int j = 0; j < jlen; j++) {
                if (i == 0&&j==0) {
                    min[0][0]=grid[0][0];
                    continue;
                }
                if (i == 0) {
                    min[0][j]=min[0][j-1]+grid[0][j];
                    continue;
                }
                if (j == 0) {
                    min[i][0]=min[i-1][0]+grid[i][0];
                    continue;
                }
                min[i][j]=Math.min(min[i-1][j], min[i][j-1])+grid[i][j];
            }
        }
        return min[ilen-1][jlen-1];
    }
}
