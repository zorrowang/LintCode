/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root
     * @return: the minimum absolute difference between values of any two nodes
     */
    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        int ret = Integer.MAX_VALUE;
        if (root==null) return ret;
        ArrayList<Integer> list = new ArrayList<>();
        helper(root, list);
        for (int i=0; i<list.size()-1; i++)
            ret = Math.min(ret, Math.abs(list.get(i) - list.get(i+1)));
        return ret;
    }
    
    private void helper(TreeNode node, ArrayList<Integer> list) {
        if (node == null)   return;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}