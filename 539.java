public class Solution {
    /**
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        // write your code here
        if (nums == null || nums.length==0)
    	    return;
        int index=0;
        int len = nums.length;
        while(index < len && nums[index]!=0)
        	index++;
        for (int i=index+1; i<len; i++){
        	if (nums[i]!=0) {
        		swap(nums, i, index++);
        	}
        }
    }

    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }
}