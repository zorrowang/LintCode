public class Solution {
    /**
     * @param words: a string array
     * @return: the maximum product
     */
    public int maxProduct(String[] words) {
        // Write your code here
        if (words == null || words.length==0)   return 0;
        int[] nums = new int[words.length];
        for (int i=0; i<words.length; i++) {
            int n = 0;
            for (int j = 0; j<words[i].length(); j++)
                n = 1 << (words[i].charAt(j)-'a') | n;
            nums[i] = n;
        }
        
        int ret = 0;
        for (int i=0; i<words.length-1; i++) {
            for (int j=i+1; j<words.length-1; j++)
            if ((nums[i] & nums[j]) == 0) {
                ret = Math.max(words[i].length() * words[j].length(), ret);
            }
        }
        return ret;
    }
}