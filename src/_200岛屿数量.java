public class _200岛屿数量 {
    boolean [][]visit;
    char[][] grid;
    int count=0;
    public int numIslands(char[][] grid) {
        this.grid=grid;
        if (grid == null||grid.length==0||grid[0]==null||grid[0].length==0) {
            return 0;
        }
        visit=new boolean[grid.length][grid[0].length];
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                if (!visit[i][j]&&grid[i][j]=='1') {
                    help(i,j);
                    count++;
                }
            }
        }
        return count;
    }
    void help(int i,int j){
        if (visit[i][j]||grid[i][j]=='0') {
            return;
        }
        visit[i][j]=true;
        if (i-1>=0 ) {
            help(i-1, j);
        }
        if (i+1 <=visit.length-1) {
            help(i+1, j);
        }
        if (j-1 >= 0) {
            help(i, j-1);
        }
        if (j+1 <=visit[0].length-1) {
            help(i, j+1);
        }
    }
}
