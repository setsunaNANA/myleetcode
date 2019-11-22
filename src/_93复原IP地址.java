import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _93复原IP地址 {
    /*List<String> res=new LinkedList<>();
    List<String> tlist=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        help(s, 3);
        return res;
    }
    void help(String sub,int count){

        if (count == 0) {
            //System.out.println(Long.valueOf(sub));
            int start=0;
            while (sub.charAt(start)== '0') {
                if (start==sub.length()-1) {
                    break;
                }
                start++;
            }
            String cur=sub.substring(start);
            if (cur.length()<=3&&Integer.valueOf(sub) <=255) {
                tlist.add(cur);
                StringBuffer curres=new StringBuffer();
                for (String s:tlist
                     ) {
                    curres.append(s);
                    curres.append('.');
                }
                curres.deleteCharAt(curres.length()-1);
                res.add(new String(curres.toString()));
                tlist.remove(tlist.size()-1);
                return;
            }
            else return;
        }
        int start=0;
        for (int i = 1; i <=start+3&&i<sub.length() ; i++) {
            start=0;
            while (sub.charAt(start)== '0') {
                if (start+1==i) {
                    break;
                }
                start++;
            }
            String cur=sub.substring(start, i);
            if (Integer.valueOf(cur) <=255) {
                tlist.add(cur);
                help(sub.substring(i), count - 1);
                tlist.remove(tlist.size() - 1);
            }
        }
    }*/
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, 0, "", res);
        return res;
    }
    public void helper(String s, int n, String out, List<String> res) {
        if (n == 4) {
            if (s.isEmpty()) res.add(out);
            return;
        }
        for (int k = 1; k < 4; ++k) {
            if (s.length() < k) break;
            int val = Integer.parseInt(s.substring(0, k));
            if (val > 255 || k != String.valueOf(val).length()) continue;
            helper(s.substring(k), n + 1, out + s.substring(0, k) + (n == 3 ? "" : "."), res);
        }
    }

    public static void main(String[] args) {
        _93复原IP地址 a=new _93复原IP地址();
        a.restoreIpAddresses("0000");
    }


}
