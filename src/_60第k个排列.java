import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _60第k个排列 {
    List<String> res=new ArrayList<>();
    List<Integer> curset=new LinkedList<>();
    int kk;
    int count=0;
    public String getPermutation(int n, int k) {
        kk=k;
        for (int i = 0; i <n ; i++) {
            curset.add(i+1);
        }
        backtrack(new StringBuffer(""), curset);
        return res.get(k-1);
    }
    String backtrack(StringBuffer stringBuffer,List<Integer> curset){
        if (count ==kk ) {
            return stringBuffer.toString();
        }
        if (curset.isEmpty()) {
            res.add(stringBuffer.toString());
            count++;
        }
        for (int i=0;i<curset.size();i++)
        {
            int cur=curset.get(i);
            stringBuffer.append(String.valueOf(cur));
            curset.remove(i);
            backtrack(stringBuffer, curset);
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            curset.add(i,cur);
        }
        return null;
    }


    public static void main(String[] args) {
        _60第k个排列 a=new _60第k个排列();
        System.out.println(  a.getPermutation(3, 3));
    }
}
