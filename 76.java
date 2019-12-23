public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i=1; i<nums.length; i++) {
            for (int j=i-1; j>=0; j--) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        int ret = 0;
        for (int i : dp)
            ret = Math.max(i, ret);
        return ret;
    }
}