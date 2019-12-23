public class Solution {
    /**
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s == null && t == null) return true;
        if (s == null || t == null) return true;
        if (s.length() != t.length())   return false;
        
        int[] cnts = new int[256];
        for(int i=0; i<s.length(); i++)
            cnts[s.charAt(i)]+=1;
        for(int i=0; i<t.length(); i++) {
            if (cnts[t.charAt(i)]==0)
                return false;
            cnts[t.charAt(i)]-=1;
        }
        for(int i=0; i<cnts.length; i++) {
            if (cnts[i]!=0)
                return false;
        }
        return true;
    }
}