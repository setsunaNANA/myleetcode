public class _29两数相除 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        int flag=1;
        if (dividend<0&&divisor>0) {
            dividend=-dividend;
            flag=-1;
        }
        else if (dividend>0&&divisor<0) {
            divisor=-divisor;
            flag=-1;
        }
        else if (dividend<0&&divisor<0) {
            int j = 0;
            for (;j*divisor>=dividend&&j*divisor<=0; j++) {
            }
            return j-1;
        }
        int i=0;
        while(i*divisor<=dividend&&i*divisor>=0){
            i++;
        }
        return (i-1)*flag;
    }

    public static void main(String[] args) {
        _29两数相除 a=new _29两数相除();
        int i=(-1)*(-2147483648);
        System.out.println(i);
        System.out.println(a.divide(-1, -1));
    }


}
