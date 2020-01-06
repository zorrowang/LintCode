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
     * @param root: a root of integer
     * @return: return a list of integer
     */
    public List<Integer> largestValues(TreeNode root) {
        // write your code here
        List<Integer> ret = new ArrayList<>();
        if (root == null)   return ret;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.offer(root.val);
        Queue<TreeNode> current = new LinkedList<>();
        current.offer(root);
        Queue<TreeNode> next = new LinkedList<>();
        
        while(!current.isEmpty()) {
            TreeNode node = current.poll();
            pq.offer(node.val);
            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);
            
            if (current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                ret.add(pq.peek());
                pq = new PriorityQueue<Integer>(Collections.reverseOrder());
            }
        }
        
        return ret;
    }
}