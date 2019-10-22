public class _415字符串相加 {
    public String addStrings(String num1, String num2) {
        int [] res=new int[Math.max(num1.length(), num2.length())+1];
        int i=num1.length()-1;
        int j=num2.length()-1;
        int cur=res.length-1;
        while(i>=0||j>=0){
            int n1=i>=0?num1.charAt(i)-'0':0;
            int n2=j>=0?num2.charAt(j)-'0':0;
            res[cur-1]=(n1+n2+res[cur])/10;
            res[cur]=((n1+n2)+res[cur])%10;
            i--;
            j--;
            cur--;
        }
        StringBuilder s = new StringBuilder("");
        int m=0;
        while (m<res.length-1&&res[m]==0)m++;
        for (; m<res.length ; m++) {
            s.append(res[m]);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        _415字符串相加 a=new _415字符串相加();
        System.out.println(a.addStrings("584", "18"));
    }


}
