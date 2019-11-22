import java.util.LinkedList;
import java.util.List;

public class _93复原IP地址 {
    List<String> res=new LinkedList<>();
    List<String> tlist=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        help(s, 3);
        return res;
    }
    void help(String sub,int count){
        if (count == 0) {
            System.out.println(Integer.valueOf(sub));
            if (Integer.valueOf(sub) <=255) {
                tlist.add(sub);
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
        for (int i = 0; i <3&&i<sub.length() ; i++) {
                tlist.add(sub.substring(0, i+1));
               help(sub.substring(i+1),--count);
               tlist.remove(tlist.size()-1);
        }
    }

}
