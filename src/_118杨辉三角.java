import java.util.ArrayList;
import java.util.List;

public class _118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer>first=new ArrayList<>();
        first.add(1);
        res.add(first);
        for (int i = 1; i <numRows ; i++) {
            List<Integer>cur=new ArrayList<>();
            cur.add(1);
            for (int j = 1; j <i ; j++) {
                cur.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}
