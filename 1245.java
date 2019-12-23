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
     * @param root: t
     * @return: the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        // Write your code here
        if (root == null)   return 0;
        return helper(root.left, true) + helper(root.right, false);
    }
    
    private int helper(TreeNode root, boolean left) {
        if (root == null)   return 0;
        if (root.left == null && root.right == null)
            return left?root.val:0;
        return helper(root.left, true) + helper(root.right, false);
    }
}