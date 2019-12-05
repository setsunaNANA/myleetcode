public class _59螺旋矩阵2 {
    public int[][] generateMatrix(int n) {
        int rowmove=1,colmove=0;
        int i=0,j=0;
        int cur=1;
        boolean [][]visit=new boolean[n][n];
        int [][]res=new int[n][n];
        res[0][0]=1;
        visit[0][0]=true;
        if (n == 1) {
            return res;
        }
        while (true){
            if (i+colmove>=0&&i+colmove<n&&j+rowmove>=0&&j+rowmove<n&&!visit[i+colmove][j+rowmove]) {
                i=i+colmove;
                j=j+rowmove;
                cur++;
                res[i][j]=cur;
                visit[i][j]=true;
            }
            else if (rowmove==1&&!visit[i+1][j]) {
                rowmove=0;
                colmove=1;
            }
            else if (colmove == 1&&!visit[i][j-1]) {
                rowmove=-1;
                colmove=0;
            }
            else if (rowmove == -1&&!visit[i-1][j]) {
                rowmove=0;
                colmove=-1;
            }
            else if (colmove == -1&&!visit[i][j+1]) {
                rowmove=1;
                colmove=0;
            }
            else break;
        }
        return res;
    }
}
