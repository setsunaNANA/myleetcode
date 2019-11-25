public class _69x的平方根 {
    public int mySqrt(int x) {
        if (x == 0||x==1) {
            return x;
        }
        return help(0, x, x);
    }
    int help(int start,int end,int x){
        int mid=start+(end-start)/2;
        if (mid<=x/mid&& (mid + 1) > x / (mid + 1))return mid;
        if (mid>x/mid) {
            return help(start,mid-1,x);
        }
        else return help(mid+1,end,x);
    }

   /*int niudundiedaifa(int x){
       int a=x;
       while (!(a<=x/a&& (a + 1) > x / (a + 1))){
           a=a-a/2a;
       }

   }*/
    public static void main(String[] args) {
        _69x的平方根 a=new _69x的平方根();
        System.out.println(a.mySqrt(2147395599));
    }
}
