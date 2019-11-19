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
         if (n == 0) {
             int count=0;
             StringBuilder str=new StringBuilder("");
             for (int i = 0; i <stack.size() ; i++) {
                 tlist.add(')');
             }
             for (Character a:tlist
                  ) {
                 str.append(a);
             }
             for (int i = 0; i <stack.size() ; i++) {
                 tlist.remove(tlist.size()-1);
             }
             res.add(str.toString());
             return;
         }
         else {
             stack.push(1);
             tlist.add('(');
             help(n-1, stack,tlist);
             stack.pop();
             tlist.remove(tlist.size()-1);
             if (!stack.isEmpty()) {
                 stack.pop();
                 tlist.add(')');
                 help(n, stack,tlist);
                 stack.push(1);
                 tlist.remove(tlist.size()-1);
             }
         }
     }

    public static void main(String[] args) {
        _22括号生成 a=new _22括号生成();
        System.out.println(a.generateParenthesis(3));
    }
}
