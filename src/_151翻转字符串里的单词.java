public class _151翻转字符串里的单词 {
    public String reverseWords(String s) {
        String s1 = s.trim();

        String[] arr=s1.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=arr.length-1;i>=0;i--) {
            //System.out.println(":"+arr[i]+":");
            if (arr[i].equals("") ) {
                continue;
            }
            String cur= arr[i].trim();
            // System.out.println(":"+cur+":");
            //System.out.println();
            sb.append(cur+" ");
        }
        String res=sb.toString().trim();
        return res;
    }
}
