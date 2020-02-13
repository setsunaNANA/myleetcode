public class _37解数独 {
    public void solveSudoku(char[][] board) {
        boolean visit_row[][]=new boolean[9][9];
        boolean visit_col[][]=new boolean[9][9];
        boolean visit_box[][]=new boolean[9][9];
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if (board[i][j] != '.') {
                    visit_row[i][board[i][j]-'0'-1]=true;
                    visit_col[j][board[i][j]-'0'-1]=true;
                    visit_box[3*(i/3)+j/3][board[i][j]-'0'-1]=true;
                }
            }
        }
       /* for (int i = 0; i <9 ; i++) {
            System.out.println();
            for (int j = 0; j <9 ; j++) {
                System.out.print(visit_row[i][j]+" ");
            }
        }
        System.out.println();
        for (int i = 0; i <9 ; i++) {
            System.out.println();
            for (int j = 0; j <9 ; j++) {
                System.out.print(visit_col[i][j]+" ");
            }
        }
        System.out.println();
        for (int i = 0; i <9 ; i++) {
            System.out.println();
            for (int j = 0; j <9 ; j++) {
                System.out.print(visit_box[i][j]+" ");
            }
        }
        System.out.println();*/
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if (board[i][j] == '.') {
                    backtrack(board, visit_row, visit_col, visit_box, i, j);
                }
            }
        }

    }
    boolean backtrack(char [][]board,boolean visit_row[][],boolean visit_col[][],boolean visit_box[][],int index_row,int index_col){
        if (index_col ==9) {
            return backtrack(board, visit_row, visit_col, visit_box, index_row+1, 0);
        }
        if (index_row == 9) {
            return true;
        }
        if (board[index_row][index_col]=='.') {
            for (int i = 1; i <=9 ; i++) {
                if (visit_row[index_row][i-1]||visit_col[index_col][i-1]||visit_box[3*(index_row/3)+index_col/3][i-1]) {
                    continue;
                }
                else {
                    board [index_row][index_col]=(char)('0'+i);
                    visit_row[index_row][i-1]=true;
                    visit_col[index_col][i-1]=true;
                    visit_box[3*(index_row/3)+index_col/3][i-1]=true;

                    if (backtrack(board, visit_row, visit_col, visit_box, index_row, index_col+1)) {
                        return true;
                    }
                    else {
                        visit_row[index_row][i-1]=false;
                        visit_col[index_col][i-1]=false;
                        visit_box[3*(index_row/3)+index_col/3][i-1]=false;
                        board [index_row][index_col]='.';
                    }
                }
            }
            return false;
        }
        else return backtrack(board, visit_row, visit_col, visit_box, index_row, index_col+1);
    }
}
