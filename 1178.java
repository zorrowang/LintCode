public class Solution {
    /**
     * @param s: a string
     * @return: whether the student could be rewarded according to his attendance record
     */
    public boolean checkRecord(String s) {
        // Write your code here
        int i=0;
        int absent = 0;
        while(i < s.length()) {
            if (s.charAt(i) == 'L') {
                if (i+2 < s.length() && s.charAt(i+1) == 'L' && s.charAt(i+2) == 'L')
                    return false;
            } else if (s.charAt(i) == 'A') {
                absent += 1;
            }
            i++;
        }
        return absent <= 1;
    }
}