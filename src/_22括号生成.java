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
     void help(int n,Stack stack,ArrayList <Character>tlist){

         if (n == 0&&stack.isEmpty()) {
             for (char c:tlist.toArray()
                  ) {

             }
             res.add(String.valueOf(tlist.toArray()));
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
             help(n-1, stack,tlist);
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
