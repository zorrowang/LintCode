public class Solution {
    /**
     * @param nums: a binary array
     * @return: the maximum length of a contiguous subarray
     */
    public int findMaxLength(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0)
            return 0;
        for (int i=0; i<nums.length; i++)
            if (nums[i] == 0)   nums[i] = -1;
        
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);
        int sum = 0;
        int max = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum))
                max = Math.max(max, i-sumToIndex.get(sum));
            else
                sumToIndex.put(sum, i);
        }
        return max;
    }
}