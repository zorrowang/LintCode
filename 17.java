public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        // return helper(nums, 0);
        return helper2(nums);
    }
    
    public List<List<Integer>> helper(int[] nums, int s) {
        List<List<Integer>> ret = new ArrayList<>();
        if (s == nums.length) {
            List<Integer> l = new ArrayList<>();
            ret.add(l);
            return ret;
        }
        List<List<Integer>> l = helper(nums, s+1);
        List<List<Integer>> t = new ArrayList<>();
        for (List<Integer> list : l) {
            ArrayList<Integer> tl = new ArrayList<>();
            tl.addAll(list);
            t.add(tl);
            list.add(0, nums[s]);
        }
        ret.addAll(l);
        ret.addAll(t);
        return ret;
    }
    
    public List<List<Integer>> helper2(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        for (int i=0; i<nums.length; i++) {
            List<List<Integer>> l = new ArrayList<>();
            for (List<Integer> list : ret) {
                ArrayList<Integer> nl = new ArrayList<>();
                nl.addAll(list);
                l.add(nl);
                list.add(nums[i]);
            }
            ret.addAll(l);
        }
        return ret;
    }
}