import java.util.*;

public class _126单词接龙2 {
    //双向带保存中间结果BFS
    /*public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int len=beginWord.length();
        List<List<String>> res=new ArrayList<>();
        Queue<List<String>> queue_begin=new LinkedList<>();
        Queue<List<String>> queue_end=new LinkedList<>();
        Set<String> set_begin=new HashSet<>(wordList);
        Set<String> set_end=new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return res;
        }
        Set<String> visited_begin=new HashSet<>();
        Set<String> visited_end=new HashSet<>();
        set_begin.remove(beginWord);
        set_end.remove(endWord);


        List<String> list_begin=new ArrayList<>();
        List<String> list_end=new ArrayList<>();
        list_begin.add(beginWord);
        list_end.add(endWord);
        queue_begin.add(list_begin);
        queue_end.add(list_end);

        boolean flag_1=false;
        boolean flag_2=false;

        while (!queue_begin.isEmpty()&&!queue_end.isEmpty()&&!flag_1&&!flag_2){

           for( int beginwidth=queue_begin.size();beginwidth>0;beginwidth--) {
                List<String> cur_begin = queue_begin.poll();
                Set<String> set_temp=new HashSet<>(cur_begin);
                String subbegin = cur_begin.get(cur_begin.size() - 1);
                for (int i = 0; i < len; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        String curword = subbegin.substring(0, i) + j + subbegin.substring(i + 1, len);
                        if (set_begin.contains(curword)&&!set_temp.contains(curword)) {
                            System.out.print(curword + "'down' ");
                          //  set_begin.remove(curword);
                            List<String> temp = new ArrayList<>(cur_begin);
                            temp.add(curword);
                            queue_begin.add(temp);
                            visited_begin.add(curword);

                            if (visited_end.contains(curword)) {
                                flag_2 = true;
                            }
                            if (curword.equals(endWord)) {
                                flag_1 = true;
                            }
                        }

                    }
                }
                System.out.println();
            }
            if (flag_1 || flag_2) {
                break;
            }

            for( int endwidth=queue_end.size();endwidth>0;endwidth--){
                List<String> cur_end = queue_end.poll();
                Set<String> set_temp=new HashSet<>(cur_end);
                String subend = cur_end.get(cur_end.size() - 1);
                for (int i = 0; i < len; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        String curword = subend.substring(0, i) + j + subend.substring(i + 1, len);
                        if (set_end.contains(curword)&&!set_temp.contains(curword)) {
                            System.out.print(curword + "'up' ");
                           // set_end.remove(curword);
                            List<String> temp = new ArrayList<>(cur_end);
                            temp.add(curword);
                            queue_end.add(temp);
                            visited_end.add(curword);
                            if (visited_begin.contains(curword)) {
                                flag_2 = true;
                            }
                        }
                    }
                }
            }
            if (flag_2) {
                break;
            }
            System.out.println();
        }
        if (flag_1) {
            for (List<String> cur_begin:queue_begin
                 ) {
                String subbegin=cur_begin.get(cur_begin.size()-1);
                if (subbegin.equals(endWord)) {
                    res.add(cur_begin);
                }
            }
        }
        if (flag_2) {
            for (List<String> cur_begin:queue_begin
            ) {
                String subbegin=cur_begin.get(cur_begin.size()-1);
                for (List<String> cur_end:queue_end
                     ) {
                    String subend=cur_end.get(cur_end.size()-1);
                    if (subbegin.equals(subend)) {
                        List<String> temp_begin=new ArrayList<>(cur_begin);
                        List<String> temp_end=new ArrayList<>(cur_end);
                        temp_end.remove(cur_end.size()-1);
                        Collections.reverse(temp_end);
                        temp_begin.addAll(temp_end);
                        res.add(temp_begin);
                    }
                }
            }
        }
        return res;
    }*/


    public static void main(String[] args) {
        _126单词接龙2 a=new _126单词接龙2();

//"red"
//"tax"
//["ted","tex","red","tax","tad","den","rex","pee"]
        List<String> list=new ArrayList<>();
        list.add("ted");
        list.add("tex");
        list.add("red");
        list.add("tax");
        list.add("tad");
        list.add("den");
        list.add("rex");
        list.add("pee");
        //a.findLadders("red","tax",list);
    }

}
