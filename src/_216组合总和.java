import java.util.ArrayList;
import java.util.List;

public class _216组合总和 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        backtrack(k, n, 9, list, res);
        return res;
    }

    void backtrack(int k,int n,int max,List<Integer> list,List<List<Integer>>res){

        if (k == 0&&n==0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if ((max+(max-k+1))*k/2<n||k==0||n==0) {
            return;
        }
        for (int i = max; i >=1 ; i--) {
            list.add(i);
            backtrack(k-1, n-i, i-1, list, res);//max表示下轮所能选取的最大数值  避免了重复
            list.remove(list.size()-1);
        }
    }
}
