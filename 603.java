public class Solution {
    /*
     * @param nums: a set of distinct positive integers
     * @return: the largest subset 
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        // write your code here
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int n = nums[i];
            ArrayList<Integer> l = new ArrayList<>();
            if (i==0)   l.add(n);
            map.put(n, l);
        }
        
        for (int i=1; i<nums.length; i++) {
            ArrayList<Integer> l = map.get(nums[i]);
            for (int j=i-1; j>=0; j--) {
                ArrayList<Integer> t = map.get(nums[j]);
                if ((nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) && t.size() > l.size())
                    l = t;
            }
            l = (ArrayList)l.clone();
            l.add(nums[i]);
            map.put(nums[i], l);
        }
        
        int max = 0;
        List<Integer> ret = null;
        for (int i : map.keySet()) {
            List<Integer> l = map.get(i);
            if (l.size() > max) {
                ret = l;
                max = ret.size();
            }
        }
        return ret;
    }
}