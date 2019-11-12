import java.util.Stack;

public class _155最小栈 {
    Stack<Integer> stack;
    Stack<Integer> minstack;
    public _155最小栈() {
        this.stack=new Stack<>();
        this.minstack=new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minstack.isEmpty()||x <=minstack.peek()) {
            minstack.push(x);
        }
    }

    public void pop() {
        int x=stack.pop();
        if (minstack.peek()==x) {
            minstack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
}
