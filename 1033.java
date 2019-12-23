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
     * @return: the minimum difference between the values of any two different nodes in the tree
     */
    public int minDiffInBST(TreeNode root) {
        // Write your code here
        ArrayList<Integer> l = build(root);
        int ret = Integer.MAX_VALUE;
        for (int i=0; i<l.size()-1; i++) {
            ret = Math.min(ret, l.get(i+1)-l.get(i));
        }
        return ret;
    }
    
    private ArrayList<Integer> build(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (root==null) return ret;
        ret.addAll(build(root.left));
        ret.add(root.val);
        ret.addAll(build(root.right));
        return ret;
    }
}