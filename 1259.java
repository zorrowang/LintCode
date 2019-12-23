public class Solution {
    /**
     * @param n: a positive integer 
     * @return: the minimum number of replacements
     */
    public int integerReplacement(int n) {
        // Write your code here
        // OOM lintcode
        int[] dp = new int[n+1];
        for (int i=2; i<=n; i++) {
            if (i%2 == 0) {
                dp[i] = dp[i/2] + 1;
                // dp[i-1] = Math.min(dp[i-1], dp[i]+1);
            } else {
                dp[i] = Math.min(dp[i-1], dp[i/2+1]+1) + 1;
            }
        }
        return dp[n];
    }
}