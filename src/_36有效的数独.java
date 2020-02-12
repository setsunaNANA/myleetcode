import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _36有效的数独 {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row_set=new HashSet<>();//保存每一行已经遍历过的值
        Set<Character> col_set=new HashSet<>();//保存每一列已经遍历过的值
        Set<Character> subpart_set=new HashSet<>();//保存每个九宫格已经遍历过的值
        for (int i = 0; i <9 ; i++) {
            //清空哈希集合
                row_set.clear();////保存第i行已经遍历过的值
                col_set.clear();//保存第i列已经遍历过的值
                subpart_set.clear();//保存第i个九宫格已经遍历过的值
            for (int j = 0; j <9 ; j++) {
                if (board[i][j]!='.') {
                    if (!row_set.contains(board[i][j])) {//第i行第j列值是否重复
                        row_set.add(board[i][j]);
                    }
                    else {
                        System.out.println(i+" row "+j+" col ");
                        return false;
                    }
                }
                if (board[j][i]!='.') {
                    if (!col_set.contains(board[j][i])) {//第i列第j行值是否重复
                        col_set.add(board[j][i]);
                    }
                    else {
                        System.out.println(j+" row "+i+" col ");
                        return false;
                    }
                }
                if (board[3*(i/3)+j/3][3*(i%3)+j%3]!='.') {//第i个九宫格第j个值是否重复
                    if (!subpart_set.contains(board[3*(i/3)+j/3][3*(i%3)+j%3])) {
                        subpart_set.add(board[3*(i/3)+j/3][3*(i%3)+j%3]);
                    }
                    else {
                        /*System.out.println(i+" da "+j+" xiao ");
                        System.out.println((3*(i/3)+j/3)+" "+(3*(i%3)+j%3));
                        System.out.println(board[3*(i/3)+j/3][3*(i%3)+j%3]);
                        for (Character a:subpart_set
                             ) {
                            System.out.print(a);
                        }
                        for (int k = 0; k <9 ; k++) {
                            System.out.println();
                            for (int l = 0; l <9 ; l++) {
                                System.out.print(board[k][l]+" ");
                            }
                        }*/
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

