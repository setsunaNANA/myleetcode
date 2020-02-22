import java.util.Stack;

public class _150逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        /*输入: ["2", "1", "+", "3", "*"]
          输出: 9
          解释: ((2 + 1) * 3) = 9*/
        Stack<Integer> num=new Stack<>();
        for (int i = 0; i <tokens.length ; i++) {
            switch (tokens[i]){
                case "+":{
                    int n1=num.pop();
                    int n2=num.pop();
                    num.push(n1+n2);
                    break;
                }
                case "-":
                {
                    int n1=num.pop();
                    int n2=num.pop();
                    num.push(n2-n1);
                    break;
                }
                case "*":
                {
                    int n1=num.pop();
                    int n2=num.pop();
                    num.push(n2*n1);
                    break;
                }
                case "/":
                {
                    int n1=num.pop();
                    int n2=num.pop();
                    num.push(n2/n1);
                    break;
                }
                default:
                {
                    num.push(Integer.valueOf(tokens[i]));
                }
            }
        }
        return num.pop();
    }
}
