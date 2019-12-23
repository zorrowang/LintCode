public class Solution {
    /**
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        HashSet<Integer> set = new HashSet<>();
        for (int n: num) set.add(n);
        int ret = 0;
        for (int n: num) {
            if (!set.contains(n-1)) {
                int i = n;
                while(set.contains(i))
                    i++;
                ret = Math.max(ret, i-n);
            }
        }
        return ret;
    }
}