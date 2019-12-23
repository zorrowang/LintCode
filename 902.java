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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        // write your code here
        LinkedList<TreeNode> stack = new LinkedList<>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (k==1)   return node.val;
            else k--;
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        
        return 0;
    }
}