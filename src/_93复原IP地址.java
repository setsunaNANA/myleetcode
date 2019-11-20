import java.util.LinkedList;
import java.util.List;

public class _93复原IP地址 {
    List<String> res=new LinkedList<>();
    List<String> tlist=new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {

    }
    void help(String sub,int cur,int count){
        if (count == 0) {
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
        }
        for (int i = 0; i <3 ; i++) {
               
        }
    }

}
