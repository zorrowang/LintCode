/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: the first Node
     * @return: the answer after plus one
     */
    public ListNode plusOne(ListNode head) {
        // Write your code here
        int carry = helper(head);
        if (carry != 0) {
            ListNode node = new ListNode(carry);
            node.next = head;
            return node;
        } else {
            return head;
        }
    }
    
    private int helper(ListNode head) {
        if (head==null) return 1;
        int next = helper(head.next);
        int sum = next + head.val;
        head.val = sum % 10;
        return sum/10;
    }
}