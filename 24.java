// NOT working
// NOT O(1) solution
public class LFUCache {
    class Node {
        int val, key;
        Node left, right;
        int count;
        Node(int val, int key) {
            this.val = val;
            this.key = key;
            this.count = 1;
        }
    }
    static int CAP;
    int count;
    Node tail;
    HashMap<Integer, Node> map;
    /*
    * @param capacity: An integer
    */public LFUCache(int capacity) {
        // do intialization if necessary
        CAP = capacity;
        count = 0;
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (tail == null) {
            Node node = new Node(value, key);
            tail = node;
            this.map.put(key, node);
            count++;
        } else {
            if (this.map.containsKey(key)) {
                Node node = map.get(key);
                Node temp = node;
                while(temp.left != null && temp.left.count <= node.count) {
                    temp = temp.left;
                }
                if (temp != node) {
                    // insert left
                    if (temp.left == null && temp.count <= node.count) {
                        tail = node.left;
                        Node left = node.left;
                        Node right = node.right;
                        node.left = temp;
                        temp.right = node;
                        left = right;
                        if (right != null)
                            right.left = left;
                    } else {
                        // insert right
                        if (temp == node.left)
                            return;
                        tail = node.left;
                        Node left = node.left;
                        Node right = node.right;
                        Node tempRight = temp.right;
                        left = right;
                        if (right != null)
                            right.left = left;
                        temp.right = node;
                        node.left = temp;
                        tempRight.left = node;
                        node.right = tempRight;
                    }
                }
            } else {
                Node node = new Node(value, key);
                map.put(key, node);
                if (count == CAP) {
                    Node left = tail.left;
                    if (left != null) {
                        left.right = node;
                        node.left = left;
                    }
                    map.remove(tail.key);
                    tail = node;
                } else {
                    count++;
                    if (tail != null) {
                        tail.left = node;
                        node.right = tail;
                    }
                    tail = node;
                }
            }
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (map.containsKey(key)) {
            Node node = map.get(key);
            Node temp = node;
            while(temp.left != null && temp.left.count <= node.count) {
                temp = temp.left;
            }
            if (temp != node) {
                // insert left
                if (temp.left == null && temp.count <= node.count) {
                    tail = node.left;
                    Node left = node.left;
                    Node right = node.right;
                    node.left = temp;
                    temp.right = node;
                    left = right;
                    if (right != null)
                        right.left = left;
                } else {
                    // insert right
                    if (temp == node.left)
                        return map.get(key).val;
                    tail = node.left;
                    Node left = node.left;
                    Node right = node.right;
                    Node tempRight = temp.right;
                    left = right;
                    if (right != null)
                        right.left = left;
                    temp.right = node;
                    node.left = temp;
                    tempRight.left = node;
                    node.right = tempRight;
                }
            }
            return map.get(key).val;
        }
        else
            return -1;
    }
}