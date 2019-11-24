public class _67二进制求和 {
    public String addBinary(String a, String b) {
        if (a.length()>b.length()) {
            String t = a;
            a=b;
            b=t;
        }
        StringBuffer s1=new StringBuffer(a).reverse();
        StringBuffer s2=new StringBuffer(b).reverse();
        StringBuffer res=new StringBuffer();
        int carry=0;
        for (int i = 0; i <b.length() ; i++) {
            int curnumb1=i<a.length()?s1.charAt(i)-'0':0;
            int curnumb2=s2.charAt(i)-'0';
            int sum=carry+curnumb1+curnumb2;
            if (sum>=2) {
                carry=1;
            }
            else carry=0;
            String curres=String.valueOf(sum%2);
            res.append(curres);
        }
        if (carry == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        _67二进制求和 a=new _67二进制求和();
        System.out.println(a.addBinary("1010", "1011"));
    }
}
