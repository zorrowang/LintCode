public class Solution {
    /**
     * @param nums1: an array
     * @param nums2: an array
     * @return:  find all the next greater numbers for nums1's elements in the corresponding places of nums2
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Write your code here
        if (nums1 == null || nums2 == null) return null;
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();
        for (int n : nums2) {
            while (!stack.isEmpty() && stack.peek()<n)
                map.put(stack.pop(), n);
            stack.push(n);
        }
        int[] ret = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            ret[i] = map.getOrDefault(nums1[i], -1);
        }
        return ret;
    }
}

