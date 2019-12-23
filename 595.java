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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    int max = 0;
    
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null)   return max;
        helper(root.left, root.val, 1);
        helper(root.right, root.val, 1);
        return max;
    }
    
    private void helper(TreeNode node, int pre, int con) {
        if (node == null)   return;
        if (node.val-pre==1) {
            con += 1;
        } else {
            con = 1;
        }
        max = Math.max(con, max);
        helper(node.left, node.val, con);
        helper(node.right, node.val, con);
    }
}