public class Solution {
    /**
     * @param S: a string
     * @param words: a dictionary of words
     * @return: the number of words[i] that is a subsequence of S
     */
    public int numMatchingSubseq(String S, String[] words) {
        // Write your code here
        int ret = 0;
        for (String w : words) 
            if (helper(S, w))
                ret += 1;
        return ret;
    }
    
    public boolean helper(String s, String w) {
        if (s.length() < w.length())    return false;
        int cur = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == w.charAt(cur)) {
                cur += 1;
                if (cur >= w.length())
                    return true;
            }
        }
        return false;
    }
}