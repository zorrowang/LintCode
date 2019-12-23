public class Solution {
    /**
     * @param nums: an array
     * @return: the Next Greater Number for every element
     */
    public int[] nextGreaterElements(int[] nums) {
        // Write your code here
        if (nums == null)   return null;
        int[] ret = new int[nums.length];
        LinkedList<Integer> stack = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        for (int i=0; i<nums.length*2; i++) {
            int n = nums[i%nums.length];
            while(!stack.isEmpty() && stack.peek()<n) {
                ret[index.pop()] = n;
                stack.pop();
            }
            if (i < nums.length) {
                stack.push(nums[i]);
                index.push(i);
            }
        }
        while(!index.isEmpty()) {
            ret[index.pop()] = -1;
        }
        return ret;
    }
}
