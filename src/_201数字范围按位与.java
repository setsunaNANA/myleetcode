public class _201数字范围按位与 {
    public int rangeBitwiseAnd(int m, int n) {
        while (n>m){
            n&=(n-1);//每次把n的最低位变成0
        }
        return n;
    }
}
