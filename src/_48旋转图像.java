import java.util.Formatter;

public class _48旋转图像 {
    public void rotate(int[][] matrix) {
        if (matrix == null||matrix.length==0) {
            return ;
        }
        int curstart=0;
        int curend=matrix.length-1;
        Formatter formatter = new Formatter(System.out);
        while (curstart<curend){
            System.out.println("curstart="+curstart+"curend="+curend);
            for (int i = curstart; i <curend ; i++) {
                formatter.format("交换[%d][%d]和[%d][%d]",i,curstart,curend,i);
                swap(matrix, i,curstart,curend,i);
                formatter.format("交换[%d][%d]和[%d][%d]",curend,i,curend-i+curstart,curend);
                swap(matrix, curend,i,curend-i+curstart,curend);
                formatter.format("交换[%d][%d]和[%d][%d]",curend-i+curstart,curend,curstart,curend-i+curstart);
                swap(matrix,curend-i+curstart,curend,curstart,curend-i+curstart);

                System.out.println();System.out.println();
            }
            curstart++;
            curend--;
        }
        formatter.close();
    }
    void swap(int[][] matrix,int i1,int j1,int i2,int j2){
        int t=matrix[i1][j1];
        matrix[i1][j1]=matrix[i2][j2];
        matrix[i2][j2]=t;
    }

}
