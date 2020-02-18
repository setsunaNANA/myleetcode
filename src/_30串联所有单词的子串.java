import java.util.*;

public class _30串联所有单词的子串 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<>();
        int s_len=s.length();
        int size=words.length;
        if (size == 0) {
            return res;
        }
        int word_len=words[0].length();
        int sub_len=word_len*size;

        if (word_len > s_len) {
            return res;
        }
        Map<String,Integer> all_map=new HashMap<>();
        for (String t:words
             ) {
            if (all_map.containsKey(t)) {
                all_map.put(t,all_map.get(t)+1);
            }
            else all_map.put(t, 1);
        }

        for (int i = 0; i <=s_len-sub_len ; i++) {
            int start = i;
            Map<String,Integer> cur_map=new HashMap<>();
            for (; start-i <sub_len ;  start+=word_len) {
                String sub=s.substring(start, start+word_len);
                if (all_map.containsKey(sub)) {
                    if (cur_map.containsKey(sub)) {
                        int all_count=all_map.get(sub);
                        int cur_count=cur_map.get(sub);
                        if (cur_count < all_count) {
                            cur_map.put(sub,cur_count+1);
                            continue;
                        }
                        else
                            break;
                    }
                    else {
                        cur_map.put(sub,1);
                        continue;
                    }
                }
                else
                    break;
            }
            System.out.println( start-i);
            if ( start-i==sub_len) {
                res.add(i);
            }
        }
        return res;
    }
}
