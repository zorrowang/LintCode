public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target: An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if (candidates == null || candidates.length==0)
            return ret;
        Arrays.sort(candidates);
        return helper(candidates, target, 0);
    }
    
    public List<List<Integer>> helper(int[] candidates, int target, int index) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if (target == 0) {
             ret.add(new ArrayList<>());
             return ret;
        }
        if (index>=candidates.length || candidates[index] > target)
            return null;
            
        if (candidates[index] == target) {
            ret.add(new ArrayList<>());
            ret.get(0).add(candidates[index]);
            return ret;
        }
        for (int i=index; i<candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1])
                continue;
            List<List<Integer>> list = helper(candidates, target-candidates[i], i);
            if (list != null) {
                for (List<Integer> l : list)
                    l.add(0, candidates[i]);
                ret.addAll(list);
            }
        }
        return ret;
    }
}