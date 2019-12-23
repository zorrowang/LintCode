public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        for(int i=0; i<26; i++) {
            int s=0, t=str.length()-1;
            while(s<=t && str.charAt(s)-'a'!=i)
                s++;
            if (s == str.length()) continue;
            while(s<=t && str.charAt(t)-'a'!=i)
                t--;
            if (s==t)   return str.charAt(s);
        }
        return ' ';
    }
}