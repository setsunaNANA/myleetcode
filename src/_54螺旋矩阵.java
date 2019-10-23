import java.util.ArrayList;
import java.util.List;

public class _54螺旋矩阵 {
    private List<Integer> res=new ArrayList<>();
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null||matrix.length==0||matrix[0].length==0) {
            return null;
        }
        int rowbegin=0;
        int rowend=matrix.length-1;
        int colbegin=0;
        int colend=matrix[0].length-1;
        while(rowbegin<=rowend&&colbegin<=colend){
            help(rowbegin,colbegin,rowend,colend, matrix);
            rowbegin++;
            rowend--;
            colbegin++;
            colend--;
        }
        return res;
    }

    private void help(int rowbegin, int colbegin, int rowend, int colend,int[][] matrix) {
        for (int i = colbegin; i <=colend ; i++) {
            res.add(matrix[rowbegin][i]);
        }
        for (int i = rowbegin+1; i <=rowend ; i++) {
            res.add(matrix[i][colend]);
        }
        if (rowbegin+1 <= rowend) {
            for (int i = colend-1; i >=colbegin ; i--) {
                res.add(matrix[rowend][i]);
            }
        }
        if (colbegin <= colend-1) {
            for (int i = rowend-1; i >=rowbegin+1 ; i--) {
                res.add(matrix[i][colbegin]);
            }
        }

        /*
        if (rowbegin+1 <= rowend) {

            for (int i = rowbegin+1; i <=rowend ; i++) {
                res.add(matrix[i][colend]);
            }
            if (colbegin <= colend-1) {
                for (int i = colend-1; i >=colbegin ; i--) {
                    res.add(matrix[rowend][i]);
                }
                    if (rowend-1 <= rowbegin+1) {
                        for (int i = rowend-1; i >=rowbegin+1 ; i--) {
                            res.add(matrix[i][colbegin]);
                     }
                 }
              }
        }*/
    }

    public static void main(String[] args) {
        _54螺旋矩阵 a=new _54螺旋矩阵();
        System.out.println(a.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
    }
    }

