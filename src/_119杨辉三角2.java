import java.util.ArrayList;
import java.util.List;

public class _119杨辉三角2 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        if (rowIndex == 0) {
            res.add(1);
            return res;
        }
        if (rowIndex == 1) {
            res.add(1);
            res.add(1);
            return res;
        }
        int []dp=new int[rowIndex+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=rowIndex ; i++) {
            //这里要倒着遍历 因为正着遍历会覆盖dp[j]
            for (int j = i; j >0 ; j--) {
                dp[j]=dp[j-1]+dp[j];
            }
        }
        for (int v:dp
             ) {
            res.add(v);
        }
        return res;
    }
}
