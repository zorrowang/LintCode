public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> ret = new ArrayList<>();
        helper(n, 0, 0, "", ret);
        return ret;
    }
    
    private void helper(int n, int left, int right, String str, List<String> list) {
        if (left==n && right==n) {
            list.add(str);
            return;
        }
        if (n < left || n < right || right > left) 
            return;
        helper(n, left+1, right, str+"(", list);
        helper(n, left, right+1, str+")", list);
    }
}