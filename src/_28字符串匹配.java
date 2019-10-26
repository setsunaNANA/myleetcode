public class _28字符串匹配 {
    public int strStr(String haystack, String needle) {
        if (haystack.length()==0||haystack==null) {
            return 0;
        }
        if (needle.length()==0||needle==null) {
            return 0;
        }
        int next[]=next(needle);
        int i=0;
        int j=0;
        while(i<haystack.length()&&j<needle.length()){
            if (j==-1||haystack.charAt(i) ==needle.charAt(j) ) {
                i++;j++;
            }
            else {
                j=next[j];
            }
        }
        if (j == needle.length()) {
            return i-needle.length();
        }
        else return 0;
    }
    /*


    int [] next(String needle){
        int []next = new int[needle.length()];
        next[0]=-1;
        int i=0;
        int j=-1;
        while (i<needle.length()-1)
            if (j==-1||needle.charAt(j) == needle.charAt(i)) {
                next[++i]=++j;
            }
            else {
                j=next[j];
            }
            return next;
    }*/
    int [] next(String needle){
        int []next = new int[needle.length()];
        next[0]=-1;
        int i=0;
        int j=-1;
        while (i<needle.length()-1)
            if (j==-1||needle.charAt(j) == needle.charAt(i)) {
               i++;
               j++;
                if (needle.charAt(j) != needle.charAt(i)) {
                        next[i]=j;
                    }
                else {
                    next[i]=next[j];
                }
                }

            else {
                j=next[j];
            }
        return next;
    }

    public static void main(String[] args) {
        _28字符串匹配 a= new _28字符串匹配();
        System.out.println(a.strStr(new String("hello"), new String("ll")));
    }
}
