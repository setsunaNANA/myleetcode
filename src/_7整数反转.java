public class _7整数反转 {
    public int reverse(int x) {
        long res=0;
        int cur=x;
        while(cur!=0){
            res=res*10+cur%10;
            cur=cur/10;
        }
        if (res>Integer.MAX_VALUE||res<Integer.MIN_VALUE) {
            return  0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(-12%10);
    }
}
