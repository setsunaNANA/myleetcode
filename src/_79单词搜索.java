public class _79单词搜索 {
    private boolean flag=false;
    public boolean exist(char[][] board, String word) {
        if (board == null||board.length==0||board[0].length==0) {
            return false;
        }
        boolean [][]visit=new boolean[board.length][board[0].length];

        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if (flag) {
                    return false;
                }
                if (help(board,i,j,0,word,visit)) {
                    return true;
                }
            }
        }
        return false;
    }
    boolean help(char[][]board,int i,int j,int index,String word,boolean [][]visit){
        boolean w=false;
        boolean a=false;
        boolean s=false;
        boolean d=false;
        if (i<0 || j<0 || i == board.length || j == board[i].length) return false;
        if (board[i][j] == word.charAt(index)) {
            visit[i][j]=true;
            System.out.printf("board[%d][%d]=%c",i,j,board[i][j]);
            System.out.println();
            if (index == word.length()-1) {
                return true;
            }
            if (i!= 0&&!visit[i-1][j]) {
                System.out.printf("board[%d][%d]=%c——>board[%d][%d]=%c",i,j,board[i][j],i-1,j,board[i-1][j]);
                System.out.println();
                w=help(board,i-1,j,index+1,word,visit);
            }
            if (j!= 0&&!visit[i][j-1]) {
                System.out.printf("board[%d][%d]=%c——>进入board[%d][%d]=%c",i,j,board[i][j],i,j-1,board[i][j-1]);
                System.out.println();
                a=help(board,i,j-1,index+1,word,visit);

            }
            if (i!= board.length-1&&!visit[i+1][j]) {
                System.out.printf("board[%d][%d]=%c——>进入board[%d][%d]=%c",i,j,board[i][j],i+1,j,board[i+1][j]);
                System.out.println();
                s=help(board,i+1,j,index+1,word,visit);

            }
            if (j!= board[0].length-1&&!visit[i][j+1]) {
                System.out.printf("board[%d][%d]=%c——>进入board[%d][%d]=%c",i,j,board[i][j],i,j+1,board[i][j+1]);
                System.out.println();
                d=help(board,i,j+1,index+1,word,visit);
            }

            visit[i][j]=false;
            return w||a||s||d;

        }
        if (index == word.length()-1) {
            flag=true;
        }
         return false;
    }

    public static void main(String[] args) {
        _79单词搜索 a=new _79单词搜索();
        char[][] board=new char[][]{{'a','a','a','a'},
                                    {'a','a','a','a'},
                                    {'a','a','a','a'},
                                    {'a','a','a','b'}};

        System.out.println(a.exist(board,new String("aaaaaaaaaaaaaaaaaaaa")));

    }
}
