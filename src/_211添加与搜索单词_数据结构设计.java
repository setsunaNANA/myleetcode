public class _211添加与搜索单词_数据结构设计 {

}
class WordDictionary {
    boolean isEnd=false;
    WordDictionary [] child;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.child=new WordDictionary[26];
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        WordDictionary root=this;
        for (int i = 0; i <word.length() ; i++) {
            int c=word.charAt(i)-'a';
            if (root.child[c] == null) {
                root.child[c]=new WordDictionary();
            }
            root=root.child[c];
        }
        root.isEnd=true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        WordDictionary root=this;
        return search(word, this);
    }
    public boolean search(String word,WordDictionary root) {
        if (word.length()==0) {
            if (root.isEnd) {
                return true;
            }
            else return false;
        }
        char cur=word.charAt(0);
        if (cur == '.') {
            for (int i = 0; i <26 ; i++) {
                if (root.child[i] != null) {
                    if (search(word.substring(1),root.child[i])) {
                        return true;
                    }
                }
            }
        }
        else {
            int c=cur-'a';
            if (root.child[c]!=null) {
                return search(word.substring(1),root.child[c]);
            }
            else return false;
        }
        return false;
    }
}
