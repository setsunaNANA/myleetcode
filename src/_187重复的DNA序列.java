import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _187重复的DNA序列 {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> own=new HashSet<>();
        Set<String> res=new HashSet<>();
        if (s.length()<10) {
            return new ArrayList<String>(res);
        }
        int mask=(1<<20)-1;//做一个底20位都是1的mask
        int subs=0;
        for (int i = 0; i <10 ; i++) {
             int cur=convert(s.charAt(i));
             subs=(subs<<2)|cur;
        }
        System.out.println(subs);
        own.add(subs);
        for (int i = 10; i <s.length() ; i++) {
            subs=(subs<<2)|convert(s.charAt(i));
            subs=subs&mask;
            //System.out.println(subs);
            if (own.contains(subs)) {
                res.add(s.substring(i+1-10, i+1));
            }
            else own.add(subs);
        }
        return new ArrayList<String>(res);
    }

    int convert(char c){
        switch (c){
            case 'A':return 0;
            case 'C':return 1;
            case 'G':return 2;
            case 'T':return 3;
            default:return -1;
        }

    }

}
