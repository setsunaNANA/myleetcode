public class _208实现Trie前缀树 {

}

class Trie {
    boolean isEnd=false;
    Trie []children=new Trie[26];
    /** Initialize your data structure here. */
    public Trie() {

    }
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root=this;
        for (int i = 0; i <word.length() ; i++) {
            int index=word.charAt(i)-'a';
            if (root.children[index]==null ){
                root.children[index]=new Trie();
            }
            root=root.children[index];
        }
        root.isEnd=true;
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root=this;
        for (int i = 0; i <word.length() ; i++) {
            int index=word.charAt(i)-'a';
            if (root.children[index]==null) {
                return false;
            }
                root=root.children[index];
        }
        if (root.isEnd) {
            return true;
        }
        else return false;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie root=this;
        for (int i = 0; i <prefix.length() ; i++) {
            int index=prefix.charAt(i)-'a';
            if (root.children[index]==null) {
                return false;
            }
            else {
                root=root.children[index];
        }
        }
        return true;
    }
}
