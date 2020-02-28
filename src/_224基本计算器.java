import java.util.Stack;

public class _224基本计算器 {
    public int calculate(String s) {
        Stack<Integer> num=new Stack<>();
        Stack<Character> operator=new Stack<>();
        for (int i = 0; i <s.length() ;i++) {
            char c=s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                operator.push(c);
            }
            if (c == ')') {
                while (operator.peek()!='('){
                    char op=operator.pop();
                    int n1=num.pop();
                    int n2=num.pop();
                    if (op == '+') {
                        num.push(n1+n2);
                    }
                    else num.push(n2-n1);
                }
                operator.pop();
            }
            if (c == '+'||c == '-') {
                while (!operator.isEmpty()&&(operator.peek()=='+'||operator.peek()=='-')){
                    char op=operator.pop();
                    int n1=num.pop();
                    int n2=num.pop();
                    if (op == '+') {
                        num.push(n1+n2);
                    }
                    else num.push(n2-n1);
                }
                operator.push(c);
            }
            if (s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9) {
                StringBuilder n = new StringBuilder();
                while(i<s.length()&&s.charAt(i)-'0'>=0&&s.charAt(i)-'0'<=9){
                    n.append(s.charAt(i));
                    i++;
                }
                num.push(Integer.valueOf(n.toString()));
                i--;
            }
        }

        if (operator.isEmpty()) {
            return num.pop();
        }char op=operator.pop();
        int n1=num.pop();
        int n2=num.pop();
        if (op == '+') {
            num.push(n1+n2);
        }
        else num.push(n2-n1);
        //  System.out.println(n2+""+op+""+n1+"="+num.peek());
        return  num.pop();
    }

    public static void main(String[] args) {
        _224基本计算器 a=new _224基本计算器();
        a.calculate("2-(5-6)");
    }
}
