/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm to
     * serialize a binary tree which denote by a root node to a string which can be
     * easily deserialized by your own "deserialize" method later.
     */
    static string SP = ",";
    static string NULL = "#";

    public String serialize(TreeNode root) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (root == null)
            sb.append(NULL).append(SP);
        else {
            sb.append(node.val).append(SP);
            sb.append(serializeHelper(node.left));
            sb.append(serializeHelper(node.right));
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly you
     * serialized at method "serialize", that means the data is not given by system,
     * it's given by your own serialize method. So the format of data is designed by
     * yourself, and deserialize it here as you serialize it in "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(SP)));
        return deserializeHelper(nodes);
    }

    private TreeNode deserializeHelper(Deque<String> nodes) {
        String n = nodes.removeFirst();
        if (n.equals(NULL))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.parseInt(n));
            node.left = deserializeHelper(nodes);
            node.right = deserializeHelper(nodes);
        }
        return node;
    }
}