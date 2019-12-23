public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // write your code here
        if (nums==null || nums.length==0)   return 0;
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if (i==0) {
                left[0] = nums[i]==1 ? 1:0;
                right[nums.length-1] = nums[nums.length-1]==1 ? 1:0;
            } else {
                left[i] = nums[i]==1 ? left[i-1]+1 : 0;
                right[nums.length-1-i] = nums[nums.length-1-i]==1 ? right[nums.length-i]+1 : 0;
            }
        }
        int ret = 0;
        for(int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                if (i==0)   ret = Math.max(ret, right[i+1]+1);
                else if (i==nums.length-1)  ret = Math.max(ret, left[i-1]+1);
                else ret = Math.max(ret, left[i-1]+right[i+1]+1);
            }
        }
        return ret;
    }
}