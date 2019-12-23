public class Solution {
    /**
     * @param nums: an array
     * @return: the shortest subarray's length
     */
    public int findUnsortedSubarray(int[] nums) {
        // Write your code here
        LinkedList<Integer> minStack = new LinkedList<>();
        LinkedList<Integer> maxStack = new LinkedList<>();
        boolean minBreak = false;
        boolean maxBreak = false;
        
        for (int i=0; i<nums.length; i++) {
            if ((minStack.isEmpty() || minStack.peek() <= nums[i]) && !minBreak)
                minStack.push(nums[i]);
            else {
                while(!minStack.isEmpty() && minStack.peek() > nums[i]) {
                    minStack.pop();
                }
                minBreak = true;
            }

            if ((maxStack.isEmpty() || maxStack.peek() >= nums[nums.length-i-1]) && !maxBreak)
                maxStack.push(nums[nums.length - i - 1]);
            else {
                while(!maxStack.isEmpty() && maxStack.peek() < nums[nums.length-i-1]) {
                    maxStack.pop();
                }
                maxBreak = true;
            }
        }
        
        return nums.length==minStack.size() ? 0 : nums.length-minStack.size()-maxStack.size();
    }
}