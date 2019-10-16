public class _14最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i <strs.length ; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
            }
        }
        for (int i = 0; i <min ; i++) {
            char a=strs[0].charAt(i);
            for (int j = 1; j <strs.length ; j++) {
                if (strs[j].charAt(i)!=a){
                    String res=strs[0].substring(0, i);

                    return res;
                }
            }

        }
        return strs[0].substring(0, min);
    }

    public static void main(String[] args) {
        _14最长公共前缀 a=new _14最长公共前缀();
        System.out.println(a.longestCommonPrefix(new String[]{"aa","a"}));

    }
}
