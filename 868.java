public class Solution {
    /**
     * @param nums: an array
     * @param k: an integer
     * @return: the maximum average value
     */
    public double findMaxAverage(int[] nums, int k) {
        // Write your code here
        int cur = 0;
        int ret = Integer.MIN_VALUE;
        
        if (nums==null || nums.length<k)
            return ret;
            
        for (int i=0; i<nums.length; i++) {
            if (i<k)
                cur += nums[i];
            else {
                ret = Math.max(ret, cur);
                cur = cur + nums[i] - nums[i-k];
            }
        }
        ret = Math.max(ret, cur);
        return (double)ret / k;
    }
}