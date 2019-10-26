import java.util.Stack;

public class _20有效的括号 {
    public boolean isValid(String s) {
        if (s == "" || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()){
                char t = stack.pop();
                switch (t) {
                    case '(':
                        if (s.charAt(i) != ')') return false;
                        break;
                    case '[':
                        if (s.charAt(i) != ']') return false;
                        break;
                    case '{':
                        if (s.charAt(i) != '}') return false;
                        break;
                       }
                }
                else return false;
            }
        }
        if (!stack.isEmpty()) {
            return false;
        } else return true;
    }

    public static void main(String[] args) {
        _20有效的括号 a=new _20有效的括号();
        System.out.println(a.isValid(new String("()[]{}")));
    }
}
