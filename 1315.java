public class Solution {
    /**
     * @param nums:  a sorted integer array without duplicates
     * @return: the summary of its ranges
     */
    public List<String> summaryRanges(int[] nums) {
        // Write your code here
        ArrayList<String> ret = new ArrayList<>();
        if (nums==null || nums.length==0)   return  ret;
        int start = 0, end = 0;
        while (end < nums.length) {
            if (nums[end]-nums[start] != end-start) {
                ret.add(gen(nums[start], nums[end-1]));
                start = end;
            }
            end++;
        }
        ret.add(gen(nums[start], nums[end-1]));
        return ret;
    }
    
    private String gen(int n1, int n2) {
        if (n1==n2) return String.valueOf(n1);
        else return n1+"->"+n2;
    }
}