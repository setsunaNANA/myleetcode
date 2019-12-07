import java.util.ArrayList;
import java.util.List;

public class _77组合 {
    List<List<Integer>> res=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> tlist=new ArrayList<>();
        help(0,k,1,n,tlist);
        return res;
    }
    void help(int count,int k,int start,int end,List<Integer> tlist){
        if (count == k) {
            res.add(new ArrayList(tlist));
            return;
        }
        for (int i = start; i <=end ; i++) {
            tlist.add(i);
            help(count+1, k, i+1, end, tlist);
            tlist.remove(tlist.size()-1);
        }
    }
}
