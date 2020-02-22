public class _190颠倒二进制位 {
    public int reverseBits(int n) {
        /*
            11101
            10111

            1110
            1

            111
            10

            11
            101
        * */
        int res=0;
        for (int i=0;i<32;i++){
            res=res<<1;
            int cur=n&1;
            res=res|cur;
            n=n>>1;
        }
        return res;
    }
}
