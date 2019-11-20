
import java.util.Scanner;

import java.util.Stack;

public class Main {
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
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len=input.nextInt();
        int pushed[]=new int[len];
        int poped[]=new int[len];
        for (int i = 0; i <len ; i++) {
            pushed[i]=input.nextInt();
        }
        for (int i = 0; i <len ; i++) {
            poped[i]=input.nextInt();
        }
        input.close();
        Main main = new Main();
        System.out.println(main.validateStackSequences(pushed, poped));
    }
}
