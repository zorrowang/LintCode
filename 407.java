public class Solution {
    /**
     * @param digits: a number represented as an array of digits
     * @return: the result
     */
    public int[] plusOne(int[] digits) {
        // write your code here
        int carry = 0;
        for (int i=digits.length-1; i>=0; i--) {
            if (i==digits.length-1)
                digits[i]+=1;
            digits[i] += carry;
            carry = digits[i]/10;
            digits[i] %= 10;
        }
        
        if (carry > 0) {
            int[] ret = new int[digits.length+1];
            System.arraycopy(digits, 0, ret, 1, digits.length);
            ret[0] = carry;
            return ret;
        } else {
            return digits;
        }
    }
}