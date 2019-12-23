public class Solution {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        // write your code here
        int i=0, j=num.length()-1;
        while(i < j) {
            if (num.charAt(i) == '0') {
                if (num.charAt(j) == '0') {
                    i++;
                    j--;
                }
                else    return false;
            }
            
            if (num.charAt(i) == '8') {
                if (num.charAt(j) == '8') {
                    i++;
                    j--;
                }
                else    return false;
            }
            
            if (num.charAt(i) == '1') {
                if (num.charAt(j) == '1') {
                    i++;
                    j--;
                }
                else    return false;
            }
            
            if (num.charAt(i) == '6') {
                if (num.charAt(j) == '9') {
                    i++;
                    j--;
                }
                else    return false;
            }
            
            if (num.charAt(i) == '9') {
                if (num.charAt(j) == '6') {
                    i++;
                    j--;
                }
                else    return false;
            }
        }
    
        if (i == j)
            return num.charAt(i)=='0' || num.charAt(i)=='1' || num.charAt(i)=='8';
        else
            return true;
    }
}