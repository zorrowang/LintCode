public class Solution {
    /**
     * @param s: A string
     * @param k: An integer
     * @return: An integer
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s==null || s.isEmpty() || k<=0)  return 0;
        int start=0, end=0;
        int[] cnt = new int[256];
        int ret = 0, cur = 0;
        while(end < s.length()) {
            int n = s.charAt(end);
            if (cnt[n] == 0)
                cur++;
            cnt[n]++;
            if (cur <= k)   ret = Math.max(ret, end-start+1);
            while (cur > k && start < end) {
                int m = s.charAt(start++);
                cnt[m]--;
                if (cnt[m]==0)  cur--;
            }
            end++;
        }
        return ret;
    }
}