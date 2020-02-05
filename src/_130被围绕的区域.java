public class _130被围绕的区域 {
    public void solve(char[][] board) {
        if (board == null||board.length==0) {
            return;
        }
        int high=board.length;
        int width=board[0].length;
        boolean [][]visited=new boolean[high][width];
        for (int i = 0; i < high; i++) {
            DFS_edge(i, 0, board, visited);
        }
        for (int j = 0; j< width; j++) {
            DFS_edge(0, j, board, visited);
        }
        for (int i = 0; i < high; i++) {
            DFS_edge(i, width-1, board, visited);
        }
        for (int j = 0; j< width; j++) {
            DFS_edge(high-1, j, board, visited);
        }
        for (int i = 0; i <high ; i++) {
            for (int j = 0; j <width ; j++) {
                if (board[i][j]=='E') {
                    board[i][j]='O';
                    continue;
                }
                if (board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }

    }
    void DFS_edge(int i,int j,char[][] board,boolean [][]visited){
       /* int high=board.length;
        int width=board[0].length;*/

        if (i<0||j<0||i>=board.length||j>=board[0].length||visited[i][j]) {
            return;
        } System.out.println("this is "+i+" "+j+"="+board[i][j]);
        if (board[i][j]=='O') {
            System.out.println(i+" "+j+"=E");
            board[i][j]='E';
            visited[i][j]=true;
            DFS_edge(i-1, j,board,visited);
            DFS_edge(i+1, j,board,visited);
            DFS_edge(i, j-1,board,visited);
            DFS_edge(i, j+1,board,visited);
        }
    }
}
