public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length==0) return 0;
        int min = prices[0], max = prices[0];
        int ret = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] >= max) {
                max = prices[i];
                ret = Math.max(ret, max-min);
            } else if (prices[i] < min) {
                min = prices[i];
            }
            ret = Math.max(ret, prices[i]-min);
        }
        return ret;
    }
}