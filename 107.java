public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    // Solution #1: OOM on both leetcode and lintcode
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s.length()==0)  return true;
        return helper(s, 0, dict);
    }
    
    private boolean helper(String s, int start, Set<String> dict) {
        if (dict.contains(s.substring(start)))   return true;
        for (int i=start+1; i<s.length(); i++) {
            String sub = s.substring(start, i);
            if (dict.contains(sub) && helper(s, i, dict))
                return true;
        }
        return false;
    }

    // Solution #2: DP, passed in leetcode, but OOM on lintcode
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if (s.length()==0)  return true;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i=s.length()-1; i>=0; i--) {
            for (int j=i+1; j<=s.length(); j++) {
                if (dict.contains(s.substring(i, j)) && (j==s.length() || dp[j][s.length()-1])) {
                    dp[i][s.length()-1] = true;
                    break;
                }
            }
        }
        return dp[0][s.length()-1];
    }
}