public class Trie {
    class Node {
        char ch;
        boolean isLeaf;
        Node[] children;
        
        Node(char ch) {
            this.ch = ch;
            children = new Node[26];
        }
    }
    
    Node root;
    public Trie() {
        // do intialization if necessary
        root = new Node(' ');
    }

    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch-'a']==null) {
                cur.children[ch-'a']=new Node(ch);
            }
            cur = cur.children[ch-'a'];
        }
        cur.isLeaf = true;
    }

    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node cur = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.children[ch-'a']==null) {
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return cur.isLeaf == true;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node cur = root;
        for (int i=0; i<prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.children[ch-'a']==null) {
                return false;
            }
            cur = cur.children[ch-'a'];
        }
        return true;
    }
}