import java.util.LinkedList;
import java.util.Queue;

public class _225用队列实现栈 {
    class MyStack {
        Queue<Integer> empty;
        Queue<Integer> noempty;

        /** Initialize your data structure here. */
        public MyStack() {
            empty=new LinkedList<>();
            noempty=new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            empty.offer(x);
            empty.addAll(noempty);
            noempty.clear();
            Queue t=empty;
            empty=noempty;
            noempty=t;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return noempty.poll();
        }

        /** Get the top element. */
        public int top() {
            return noempty.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return noempty.isEmpty();
        }
    }
}

