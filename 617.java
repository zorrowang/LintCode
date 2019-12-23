public class Solution {
    /**
     * @param nums: an array with positive and negative numbers
     * @param k: an integer
     * @return: the maximum average
     */
    // This greedy sliding window solution does NOT work
    // Testing example: nums = [10,201,11,12,13,13,202,77,89,101,-9,-10,-1,101,1001,11,203]
    //                  k = 11
    public double maxAverage(int[] nums, int k) {
        // write your code here
        double ret = -Double.MAX_VALUE;
    	if (nums==null || nums.length==0)	return ret;
    	int len = 0, start = 0;
    	double sum = 0;
    	for (int i=0; i<nums.length; i++) {
    		sum += nums[i];
    		len++;
    		if (len < k)	continue;
    		double avg = (double)sum/len;
    		while(len > k && avg > nums[start]) {
    			len--;
    			sum -= nums[start++];
    			avg = (double)sum/len;
    		}
    		ret = Math.max(ret, avg);
    	}
    	return ret;
    }
}