public class _344反转字符串 {
    public void reverseString(char[] s) {
        int i = 0;
        int j=s.length-1;
        for (; i <j ; i++,j--) {
            s[i]= (char) (s[i]^s[j]);
            s[j]= (char) (s[i]^s[j]);
            s[i]= (char) (s[i]^s[j]);
        }
    }
}
