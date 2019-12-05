public class _58最后一个单词的长度 {
    public int lengthOfLastWord(String s) {
        if (s==null||s.length()==0) {
            return 0;
        }
        int len=0;
        int start= s.length()-1;
        while (start>=0&&s.charAt(start)==' ')start--;
        for (int i =start; i >=0 ; i--,len++) {
            if (s.charAt(i)==' ') {
                break;
            }
        }
        return len;
    }
}
