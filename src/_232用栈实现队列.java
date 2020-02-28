import java.util.Queue;
import java.util.Stack;

public class _232用栈实现队列 {
    static class MyQueue {
        Stack<Integer> push;
        Stack<Integer> pop;
        /** Initialize your data structure here. */
        public MyQueue() {
            push=new Stack<>();
            pop=new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            push.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
//            empty.addAll(noempty);
            if (pop.isEmpty()) {
                while (!push.isEmpty()){
                    pop.push(push.pop());
                }
            }
             return pop.pop();
        }

        /** Get the front element. */
        public int peek() {

            if (pop.isEmpty()) {
                while (!push.isEmpty()){
                    pop.push(push.pop());
                }
            }

             return pop.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return push.isEmpty()&&pop.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.push(1); myQueue.push(2);
        System.out.println(myQueue.peek()+" "+myQueue.pop);

    }
}
