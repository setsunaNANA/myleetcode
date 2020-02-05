import java.util.*;

public class _127单词接龙 {
    /* 单向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set=new HashSet<>();
        Map<String,Integer> map=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        for(
                String cur:wordList
        ){
            set.add(cur);
        }
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        while (!queue.isEmpty()){
            String word=queue.poll();
            for (int i = 0; i <word.length() ; i++) {
                for (char j = 'a'; j <='z' ; j++) {
                    String curword=word.substring(0, i)+j+word.substring(i+1, word.length());
                    if (set.contains(curword)) {
                        System.out.print(curword);
                        set.remove(curword);
                        queue.add(curword);
                        map.put(curword, map.get(word)+1);
                    }
                }
            }
            System.out.println();
        }
        return map.get(endWord)==null?0:map.get(endWord);
    }*/

    //双向BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue_begin=new LinkedList<>();
        Queue<String> queue_end=new LinkedList<>();
        Set<String> set_begin=new HashSet<>(wordList);
        Set<String> set_end=new HashSet<>(wordList);
        if (!wordList.contains(endWord)) {
            return 0;
        }
        Set<String> visited_begin=new HashSet<>();
        Set<String> visited_end=new HashSet<>();
        set_begin.remove(beginWord);
        set_end.remove(endWord);
        Map<String,Integer> map_begin=new HashMap<>();
        Map<String,Integer> map_end=new HashMap<>();
        map_begin.put(beginWord, 1);
        map_end.put(endWord, 1);
        queue_begin.add(beginWord);
        queue_end.add(endWord);
        while (!queue_begin.isEmpty()&&!queue_end.isEmpty()){
            String subbegin=queue_begin.poll();
            for (int i = 0; i <subbegin.length() ; i++) {
                for (char j = 'a'; j <='z' ; j++) {
                    String curword=subbegin.substring(0, i)+j+subbegin.substring(i+1, subbegin.length());
                    if (set_begin.contains(curword)) {
                        System.out.print(curword+" down ");
                        set_begin.remove(curword);
                        queue_begin.add(curword);
                        visited_begin.add(curword);
                        map_begin.put(curword, map_begin.get(subbegin)+1);
                    }
                    if (visited_end.contains(curword)) {
                        return map_begin.get(curword)+map_end.get(curword)-1;
                    }
                    if (curword.equals(endWord)) {
                        return map_begin.get(curword);
                    }
                }
            }
            System.out.println();
            String subend=queue_end.poll();
            for (int i = 0; i <subend.length() ; i++) {
                for (char j = 'a'; j <='z' ; j++) {
                    String curword=subend.substring(0, i)+j+subend.substring(i+1, subend.length());
                    if (set_end.contains(curword)) {
                        System.out.print(curword+" up ");
                        set_end.remove(curword);
                        queue_end.add(curword);
                        visited_end.add(curword);
                        map_end.put(curword, map_end.get(subend)+1);
                    }
                    if (visited_begin.contains(curword)) {
                        return map_begin.get(curword)+map_end.get(curword)-1;
                    }
                }
            }
            System.out.println();
        }
        return 0;
    }
}
