public class Solution {
    /**
     * @param list: The coins
     * @param k: The k
     * @return: The answer
     */
    public int takeCoins(int[] list, int k) {
        // Write your code here
        if (k > list.length)    return -1;
        return helper(list, k, 0, list.length-1);
    }
    
    private int helper(int[] list, int k, int left, int right) {
        if (k == 1) return Math.max(list[left], list[right]);
        return Math.max(helper(list, k-1, left+1, right) + list[left],
                        helper(list, k-1, left, right-1) + list[right]);
    }
}

//Another solution is sliding window.