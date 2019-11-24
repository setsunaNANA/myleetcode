import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _51N皇后 {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        boolean [][]notvaild=new boolean[n][n];
        List<String> list=new ArrayList<>();
        help(0, notvaild, list);
        return res;
    }
    void help(int row,boolean[][] notvaild,List<String> list){
        if (row == notvaild.length) {
            res.add(new ArrayList<String>(list));
            return;
        }
        int len=notvaild[0].length;
        for (int i = 0; i <len ; i++) {
            if (notvaild[row][i]) {
                continue;
            }
            else {
                List<int []> record=place(row, i, notvaild,list);
                    help(row+1, notvaild, list);
                    restore(record, notvaild,list);
                    continue;
            }
        }

    }
    List<int []> place(int row,int col,boolean[][] notvaild,List<String> list){
        List<int []> record=new ArrayList<>();
        int c=0;
        for (int i = row; i <notvaild.length ; i++,c++) {
            if (!notvaild[i][col]) {
                notvaild[i][col]=true;
                record.add(new int[]{i,col});
            }
            if (c+col<notvaild[0].length&&!notvaild[i][c+col]) {
                notvaild[i][c+col]=true;
                record.add(new int[]{i,c+col});
            }
            if (col-c>=0&&!notvaild[i][col-c]) {
                notvaild[i][col-c]=true;
                record.add(new int[]{i,col-c});
            }
        }
        StringBuffer stringBuffer = new StringBuffer("");
        int j = 0;
        for (; j < col; j++) {
            stringBuffer.append(".");
        }
        stringBuffer.append("Q");
        j++;
        for (; j < notvaild[0].length; j++) {
            stringBuffer.append(".");
        }
        list.add(stringBuffer.toString());
        return record;
    }
    void restore( List<int []> record,boolean[][] notvaild,List<String> list){
        for (int []cur:record
             ) {
            notvaild[cur[0]][cur[1]]=false;
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        _51N皇后 a=new _51N皇后();
        a.solveNQueens(4);
    }
}
