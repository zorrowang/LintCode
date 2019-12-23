public class Solution {
    /**
     * @param dict: List[str]
     * @param sentence: a string
     * @return: return a string
     */
    public String replaceWords(List<String> dict, String sentence) {
        // write your code here
        if (dict==null || dict.size()==0 || sentence==null || sentence.isEmpty())
            return sentence;
        String[] array = sentence.split(" ");
        Collections.sort(dict, (w1, w2) -> w1.length()-w2.length());
        for (int i=0; i<array.length; i++) {
            for (String w : dict) {
                if (array[i].indexOf(w)==0)
                    array[i] = w;
            }
        }
        return String.join(" ", array);
    }
}

public class Solution {
    /**
     * @param dict: List[str]
     * @param sentence: a string
     * @return: return a string
     */
    public String replaceWords(List<String> dict, String sentence) {
        // write your code here
        if (dict==null || dict.size()==0 || sentence==null || sentence.isEmpty())
            return sentence;
        String[] array = sentence.split(" ");
        Trie trie = new Trie();
        for (String w : dict)   trie.add(w);
        for (int i=0; i<array.length; i++) {
            String s = trie.startWith(array[i]);
            if (!s.isEmpty())
                array[i] = s;
        }
        return String.join(" ", array);
    }
    
    class Trie {
        class TrieNode {
            char val;
            boolean isLeaf;
            TrieNode[] children;
            TrieNode(char val) {
                this.val = val;
                this.isLeaf = false;
                this.children = new TrieNode[26];
            }
        }    
        
        TrieNode root;
        Trie() {
            this.root = new TrieNode(' ');
        }
        
        void add(String str) {
            TrieNode node = root;
            for (int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if (node.children[ch-'a'] == null) {
                    node.children[ch-'a'] = new TrieNode(ch);
                }
                node = node.children[ch-'a'];
            }
            node.isLeaf = true;
        }
        
        String startWith(String str) {
            TrieNode node = root;
            for (int i=0; i<str.length(); i++) {
                char ch = str.charAt(i);
                if (node.children[ch-'a'] == null) {
                    return "";
                }
                node = node.children[ch-'a'];
                if (node.isLeaf)
                    return str.substring(0, i+1);
            }
            return "";
        }
    }
}