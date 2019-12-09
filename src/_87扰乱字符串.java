import java.util.HashMap;

public class _87扰乱字符串 {
    HashMap <String,Integer>momo=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        System.out.println(s1+" "+s2);
        int res=momo.getOrDefault(s1+"_"+s2, -1);
        if (res == 1) {
            return true;
        }
        if (res == 0) {
            return false;
        }
        if (s1.length() != s2.length()) {
            momo.put(s1+"_"+s2,0);
            return false;
        }
        if (s1.equals(s2)) {
            momo.put(s1+"_"+s2,1);
            return true;
        }
        /**/int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++)
            if (letters[i] != 0) {
            momo.put(s1+"_"+s2,0);
                return false;
            }
        for (int i = 1; i <s1.length() ; i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))&&
                    isScramble(s1.substring(i,s1.length()), s2.substring(i,s1.length()))
                    ||isScramble(s1.substring(0,i), s2.substring(s1.length()-i,s1.length()))&&
                    isScramble(s1.substring(i,s1.length()), s2.substring(0,s1.length()-i))){
                momo.put(s1+"_"+s2,1);
                return true;
            }
        }
        momo.put(s1+"_"+s2,0);
        return false;
    }
}

