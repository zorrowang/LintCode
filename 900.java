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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    int ret = 0;
    public int closestValue(TreeNode root, double target) {
        // write your code here
        ret = root.val;
        helper(root, target);
        return ret;
    }
    
    public void helper(TreeNode node, double target) {
        if (node == null)   return;
        if (Math.abs(node.val-target) < Math.abs(ret-target))
            ret = node.val;
        if (node.val == target) return;
        else if (node.val > target) helper(node.left, target);
        else helper(node.right, target);
    }
}