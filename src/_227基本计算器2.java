import java.util.Stack;

public class _227基本计算器2 {
    public int calculate(String s) {
        Stack<Integer> num=new Stack<>();
        Stack<Character> operator=new Stack<>();
        for (int i = 0; i <s.length() ;i++) {
            char c=s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (c == '*'||c == '/') {
                while (!operator.isEmpty()&&operator.peek()!='+'&&operator.peek()!='-'){
                    char op=operator.pop();
                    int n1=num.pop();
                    int n2=num.pop();
                     if (op == '*') {
                        num.push(n2*n1);
                    }
                    else if (op == '/') {
                        num.push(n2/n1);
                    }
                }
                operator.push(c);
            }
            if (c == '+'||c == '-') {
                while (!operator.isEmpty()){
                    char op=operator.pop();
                    int n1=num.pop();
                    int n2=num.pop();
                    if (op == '+') {
                        num.push(n1+n2);
                    }
                    else if (op == '-') {
                        num.push(n2-n1);
                    }
                    else if (op == '*') {
                        num.push(n2*n1);
                    }
                    else if (op == '/') {
                        num.push(n2/n1);
                    }
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


        while (!operator.isEmpty()){
            char op=operator.pop();
            int n1=num.pop();
            int n2=num.pop();
            if (op == '+') {
                num.push(n1+n2);
            }
            else if (op == '-') {
                num.push(n2-n1);
            }
            else if (op == '*') {
                num.push(n2*n1);
            }
            else if (op == '/') {
                num.push(n2/n1);
            }
        }

            return num.pop();
    }
    public static void main(String[] args) {
        _227基本计算器2 a=new _227基本计算器2();
        a.calculate("0-0");
    }
}
