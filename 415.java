public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null)  return false;
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        while(i < j) {
            while(i<s.length()-1 && !(Character.isDigit(s.charAt(i)) || 
                  Character.isLetter(s.charAt(i))))
                i++;
            while(j>=0 && !(Character.isDigit(s.charAt(j)) || 
                  Character.isLetter(s.charAt(j))))
                j--;
            if (i >= j) return true;
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}