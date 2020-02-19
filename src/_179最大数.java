import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _179最大数 {
    public String largestNumber(int[] nums) {
        List<String> list=new ArrayList<>();
        for (int elem:nums
             ) {
            list.add(String.valueOf(elem));
        }
        list.sort(new LargestNumberComparable());
        StringBuilder res=new StringBuilder("");
        for (String s:list
             ) {
            res.append(s);
        }
        if (res.charAt(0)=='0') {
            return "0";
        }
        return res.toString();
    }


}

class LargestNumberComparable implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);//若o2o1<o1o2则排序时把o1o2放到前面(设定他为小的)  这样方便之后组装返回结果
    }
}
