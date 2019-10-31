
import java.util.*;

public class _76最小覆盖子串 {
    public String minWindow(String s, String t) {

        if (t == null||t.length()==0||s.length()<t.length()) {
            return "";
        }
        int curstart=0;
        int curend=0;
        Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> tmap=new HashMap<>();
        for (int i = 0; i <t.length() ; i++) {
            if (tmap.containsKey(t.charAt(i))) {
                tmap.put(t.charAt(i),tmap.get(t.charAt(i))+1);
            }
            else  tmap.put(t.charAt(i),1);
        }
        int minlen=Integer.MAX_VALUE;
        int minindex=0;
        boolean flag=false;
        Queue<Integer> queue=new LinkedList<>();

       /* */for (int i = 0; i <s.length() ; i++) {
            if (iselem(t, s.charAt(i))) {
                curstart=i;
                curend=i+1;
                map.put(s.charAt(i),1);
                if (t.length()==1) {
                    return String.valueOf(s.charAt(i));
                }
                break;
            }
        }

        while (curend<s.length()){
            if (iselem(t, s.charAt(curend))) {
                queue.add(curend);
                if (map.containsKey(s.charAt(curend))) {
                    map.put(s.charAt(curend),map.get(s.charAt(curend))+1);
                }
                else  map.put(s.charAt(curend),1);
                if (issbustring(map,tmap, t.length())) {
                    while (issbustring(map,tmap, t.length())){
                        if (minlen > curend-curstart+1) {
                            minlen=curend-curstart+1;
                            minindex=curstart;
                            flag=true;
                        }
                        if (map.get(s.charAt(curstart))>1) {
                            map.put(s.charAt(curstart),map.get(s.charAt(curstart))-1);
                        }
                        else map.remove(s.charAt(curstart));
                        curstart=queue.remove();
                    }
                }
            }
             curend++;
        }
        if (flag) {
            return s.substring(minindex, minindex+minlen);
        }
        else return "";

    }
    boolean iselem(String t,char a){
        for (int i = 0; i <t.length() ; i++) {
            if (a == t.charAt(i)) {
                return true;
            }
        }
        return false;
    }
    boolean issbustring(Map<Character,Integer> map,Map<Character,Integer> tmap,int len){

        for (Map.Entry<Character, Integer> entry : tmap.entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            if (entry.getValue()>map.get(entry.getKey())) {
                return false;
            }
        }
         return true;
    }

    public static void main(String[] args) {
        _76最小覆盖子串 a =new _76最小覆盖子串();
        System.out.println(a.minWindow("ADOBECODEBANC",
                "ABC"));
    }
}
