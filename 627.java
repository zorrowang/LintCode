public class Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        // write your code here
        int[] cnt = new int[256];
        for (int i=0; i<s.length(); i++) {
            cnt[(int)s.charAt(i)] += 1;
        }
        
        int ret = 0;
        boolean odd = false;
        for (int c : cnt) {
            if (c%2 ==0)    ret += c;
            else {
                odd = true;
                ret += c-1;
            }
        }
        return odd?ret+1:ret;
    }
}