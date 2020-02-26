public class _214最短回文串 {
    public String shortestPalindrome(String s) {
        if (s.length()==0||s.length()==1) {
            return s;
        }
        StringBuffer t=new StringBuffer(s);
        t.reverse();
       String f=s+"#"+t.toString();
        int next[]=next(f);
        int maxdup= next[f.length()+1];//+1是保证最后一位能保存  S从头开始算最大回文长度（t的后端和前端重合的长度）因为回文一定可以重合
        System.out.println(f);
        for (int i:next
             ) {
            System.out.print(i);
        }
        StringBuffer sub=new StringBuffer(s.substring(maxdup,s.length()));//sub为s前端最大回文子串后的子串
        return sub.reverse().append(s).toString();
    }
    int []next(String s){
        int []next=new int[s.length()+1];
        next[0]=-1;
        next[1]=0;

        int j=0;
        int i=1;
        while (i<s.length()){
            if (j==-1||s.charAt(i)==s.charAt(j)){
                i++;
                j++;
                next[i]=j;
            }
            else j=next[j];
        }
        return next;
    }
}
