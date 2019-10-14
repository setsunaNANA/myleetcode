public class _9回文数 {
    public boolean isPalindrome(int x) {
        int t=x;
        if (x < 0) {
            return false;
        }
        int res=0;
        while (x>0){
            res = res*10+x%10;
            x/=10;
        }
        if (res != t) {
            return false;
        }
        return true;
    }
}
