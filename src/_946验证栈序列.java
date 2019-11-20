import java.util.Stack;

public class _946验证栈序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed==null||pushed.length==0){
            return true;
        }
        Stack<Integer> stack=new Stack<>();
        int i=0;
        int j=0;
        while (j<popped.length){
            if (stack.isEmpty()) {
                stack.push(pushed[i]);
                i++;
                continue;
            }
            if (stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
            else if (i<pushed.length) {
                stack.push(pushed[i]);
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
