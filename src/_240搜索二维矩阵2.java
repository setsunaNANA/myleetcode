public class _240搜索二维矩阵2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return false;
        }
        int i=0;
        int j=matrix[0].length-1;
        if (matrix[i][j]==target) {
            return true;
        }
        while(i<matrix.length&&j>=0&&matrix[i][j]!=target){
            if (matrix[i][j]>target) {
                j--;
            }
            else i++;
            if (i<matrix.length&&j>=0&&matrix[i][j]==target) {
                return true;
            }
        }

        return false;
    }
}
