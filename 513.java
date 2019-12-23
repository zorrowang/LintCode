public class Solution {
    /**
     * @param n: a positive integer
     * @return: An integer
     */
    // OOM
    public int numSquares(int n) {
        // write your code here
        double sqrt = Math.sqrt(n);
        int x = (int) sqrt;
        if(Math.pow(sqrt,2) == Math.pow(x,2))
            return 1;
        
        int ret = Integer.MAX_VALUE;
        for(int i=1; i<=x; i++) {
            int r = numSquares(n - i*i) + 1;
            ret = Math.min(r, ret);
        }
        return ret;
    }

    // DP
    public int numSquares2(int n) {
        // write your code here
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int sqrt = (int)Math.sqrt(n);
        
        for (int i=1; i<=sqrt; i++)
            dp[i*i] = 1;
        
        for(int i=2; i<=n; i++) {
            if (dp[i]==1)   continue;
            int s = (int)Math.sqrt(i);
            for (int j=s; j>0; j--)
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
        }
        return dp[n];
    }
}