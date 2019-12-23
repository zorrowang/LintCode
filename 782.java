public class Solution {
    /**
     * @param n: 
     * @param nums: 
     * @return: return the sum of maximum OR sum, minimum OR sum, maximum AND sum, minimum AND sum.
     */
    public long getSum(int n, int[] nums) {
        // write your code here
        if (nums==null || nums.length==0)   return 0;
        long max_or_sum = nums[0];
        long min_or_sum = nums[0];
        long max_and_sum = nums[0];
        long min_and_sum = nums[0];
        for(int i=1;i<n;i++) {
            max_or_sum |= nums[i];    
            min_or_sum = Math.min(min_or_sum,nums[i]);
            max_and_sum = Math.max(max_and_sum,nums[i]);
            min_and_sum &= nums[i]; 
        }
        return max_or_sum+min_or_sum+max_and_sum+min_and_sum;
    }
}