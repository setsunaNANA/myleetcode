import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _22括号生成 {
    List<String> res=new ArrayList<>();
    List<Character> tlist =new ArrayList<>();
    Stack<Integer> stack=new Stack<>();
    public List<String> generateParenthesis(int n) {
        help(n, stack, tlist);
        return res;
    }
     void help(int n,Stack stack,List <Character>tlist){

        StringBuilder str=new StringBuilder("");
         if (n == 0&&stack.isEmpty()) {
             for (Character a:tlist
                  ) {
                 str.append(a);
             }
             res.add(str.toString());
             return;
         }
         else if (n == 0) {
             int count=0;
             while (!stack.isEmpty()){
                 count++;
                 stack.pop();
                 tlist.add('(');
                 tlist.add(')');
             }
             help(n, stack, tlist);
             for (int i = 0; i <count ; i++) {
                 stack.push(1);
                 tlist.remove(tlist.size()-1);
                 tlist.remove(tlist.size()-1);
             }
         }
         else if (stack.isEmpty()) {
             stack.push(1);
             help(n-1, stack,tlist);
             stack.pop();
         }
         else {
             stack.push(1);
             help(n-1, stack,tlist);
             stack.pop();
             if (!stack.isEmpty()) {
                 stack.pop();
                 tlist.add('(');
                 tlist.add(')');
                 help(n, stack,tlist);
                 stack.push(1);
                 tlist.remove(tlist.size()-1);
                 tlist.remove(tlist.size()-1);
             }
         }

     }
}
