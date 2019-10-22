import javax.sound.midi.SoundbankResource;

public class _43字符串相乘 {
    public String multiply(String num1, String num2) {
        String res="0";
        int sum=0;
        for (int i = 0; i <num1.length() ; i++) {
            int n=num1.charAt(num1.length()-1-i)-'0';
            if (n== 0) {
                continue;
            }
            for (int j = 0; j <num2.length() ; j++) {
                int m=num2.charAt(num2.length()-1-j)-'0';

                //String s = new String(Integer.toString((int) (m*n*(Math.pow(10, (i+j))))));
                StringBuilder o=new StringBuilder("");
                if (m== 0) {
                    continue;
                }
                for (int k = 0; k <i+j ; k++) {
                    o.append(0);
                }
                StringBuilder s = new StringBuilder(Integer.toString(m*n));
                s.append(o);
                res=add(res, s.toString());
         }
        }
        return res.toString();
    }
    public String add(String num1,String  num2){
        StringBuilder s=new StringBuilder("");
        int i=num1.length()-1;
        int j=num2.length()-1;
        int carry=0;
        while(i>=0||j>=0){
            int m=i>=0?num1.charAt(i)-'0':0;
            int n=j>=0?num2.charAt(j)-'0':0;
            int tmp=n+m+carry;
            carry=tmp/10;
            s.append(tmp%10);
            i--;j--;
        }
        if (carry == 1) {
            s.append(1);
        }
        return s.reverse().toString();
    }

    /*
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = (res[i + j + 1] + n1 * n2);
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) continue;
            result.append(res[i]);
        }
        return result.toString();
    }
     */
    public static void main(String[] args) {
        _43字符串相乘 a= new _43字符串相乘();
        //System.out.println(a.add("15", "12"));
        System.out.println(a.multiply(new String("52"),new String("60")));
    }


}
