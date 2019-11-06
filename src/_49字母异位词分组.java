import java.util.*;

public class _49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        if (strs == null||strs.length==0) {
            return res;
        }
        Map<String,List<String>> map=new HashMap<>();
        for (String curstr:strs
             ) {
            char []c=curstr.toCharArray();
            Arrays.sort(c);
            if (!map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c), new ArrayList<String>());
            }
            map.get(String.valueOf(c)).add(curstr);
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
           res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args) {
        _49字母异位词分组 a=new _49字母异位词分组();
        a.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}
