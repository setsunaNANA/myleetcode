public class _74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0||matrix[0]==null||matrix[0].length==0) {
            return false;
        }
        int rowlen=matrix.length;
        int collen=matrix[0].length;
        int start=0;
        int end=rowlen*collen-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            if (matrix[mid/collen][mid%collen] == target ) {
                return true;
            }
            else if (matrix[mid/collen][mid%collen] < target) {
                start=mid+1;
            }
            else end=mid-1;
        }
        return false;
    }

    public static void main(String[] args) {
        _74搜索二维矩阵 a=new _74搜索二维矩阵();
        System.out.println(a.searchMatrix(new int[][]{{1,3}}, 3));
    }
}
