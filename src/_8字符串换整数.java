public class _8字符串换整数 {
    public int myAtoi(String str) {
        String newstr =str.trim();
        if (newstr.equals("") ) {
            return 0;
        }
        System.out.println(Integer.MIN_VALUE);
        int sign=1;
        int start=0;
        long res = 0;
        switch (newstr.charAt(0)){
            case '+':start++; break;
            case '-':sign=-1;start++;break;
        }
        for (int i = start; i<newstr.length(); i++) {
            if ( Character.isDigit(newstr.charAt(i))) {
                res=res*10+(newstr.charAt(i)-'0');
                System.out.println(res+" "+(int)res);
                long t=sign*res;
                if (t>Integer.MAX_VALUE) {
                    return  Integer.MAX_VALUE;
                }
                if (t<Integer.MIN_VALUE) {
                    return  Integer.MIN_VALUE;
                }
            }
            else break;
        }
        return  sign*(int)(res);
    }

    public static void main(String[] args) {
        _8字符串换整数 a =new _8字符串换整数();
        System.out.println(a.myAtoi("-91283472332"));
    }
}
