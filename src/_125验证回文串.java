public class _125验证回文串 {
    public boolean isPalindrome(String s) {
        if (s == null||s=="") {
            return true;
        }
        s = s.toLowerCase(); //统一转为小写
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
                continue;
            }
            if (s.charAt(start)==s.charAt(end)) {
                start++;
                end--;
            }
            else return false;
        }
        return true;
    }
}
