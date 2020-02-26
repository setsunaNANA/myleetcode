import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.Deflater;

public class _212单词搜索2 {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> res=new HashSet<>();
        Trie trie=new Trie();
        boolean visit[][]=new boolean[board.length][board[0].length];
        for (String s:words
        ) {
            trie.insert(s);
        }
        for (int i = 0; i <26 ; i++) {
            if (trie.child[i]!= null) {
                char c=(char)('a'+i);
                for (int j = 0; j <board.length ; j++) {
                    for (int k = 0; k <board[0].length ; k++) {
                        if (board[j][k] == c) {
                            //System.out.println(j+","+k+"="+c);
                            search(trie.child[i],j,k,board,visit,res);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }
    void search(Trie root,int index_i,int index_j,char[][]board,boolean visit[][],Set <String>res){
        visit[index_i][index_j]=true;

        if (root.isEnd) {
            res.add(root.word);
        }
        for (int i = 0; i <26 ; i++) {
            if (root.child[i] != null) {
                char c=(char)('a'+i);

                boolean flag=false;
                if (index_i != 0&&!visit[index_i-1][index_j]&&board[index_i-1][index_j]==c) {

                    search(root.child[i],index_i-1,index_j,board,visit,res);

                    flag=true;
                }
                if (index_j != 0&&!visit[index_i][index_j-1]&&board[index_i][index_j-1]==c) {


                    search(root.child[i],index_i,index_j-1,board,visit,res);

                    flag=true;
                }
                if (index_i != board.length-1&&!visit[index_i+1][index_j]&&board[index_i+1][index_j]==c) {


                    search(root.child[i],index_i+1,index_j,board,visit,res);

                    flag=true;
                }
                if (index_j !=board[0].length-1&&!visit[index_i][index_j+1]&&board[index_i][index_j+1]==c ) {

                    search(root.child[i],index_i,index_j+1,board,visit,res);
                    flag=true;
                }
            }
        }
        visit[index_i][index_j]=false;
    }


    class Trie{
        boolean isEnd=false;
        String word;
        Trie []child;
        Trie(){
            this.word="";
            this.child=new Trie[26];
        }
        void insert(String word){
            Trie root=this;
            for (int i = 0; i <word.length() ; i++) {
                int c=word.charAt(i)-'a';
                if (root.child[c]==null) {
                    root.child[c]=new Trie();
                }
                root=root.child[c];
                root.word=word.substring(0,i+1);

            }
            root.isEnd=true;
        }
    }
}


