import java.util.HashMap;
import java.util.Map;

public class _205同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        for (int i = 0; i <s.length() ; i++) {
            char s_c=s.charAt(i);
            char t_c=t.charAt(i);
            if (map1.containsKey(s_c)) {
                if (t_c != map1.get(s_c)) {
                    return false;
                }
            }
            else {
                map1.put(s_c, t_c);
            }
            if (map2.containsKey(t_c)) {
                if (s_c != map1.get(t_c)) {
                    return false;
                }
            }
            else {
                map2.put(t_c, s_c);
            }
        }
        return true;
    }
}
