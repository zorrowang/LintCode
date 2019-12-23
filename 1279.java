public class Solution {
    /**
     * @param n: a non-negative integer
     * @return: number of numbers with unique digits
     */
    public int countNumbersWithUniqueDigits(int n) {
        // Write your code here 
        if (n > 10) n = 10;
        // if (n == 0) return 1;
        int[] ret = new int[n+1];
        Arrays.fill(ret, 1);
        for (int i=1; i<=n; i++) {
            int t = 9;
            ret[i] = 9;
            int j = 1;
            while(j < i) {
                ret[i] *= t--;
                j++;
            }
        }
        int sum = 0;
        for (int i=0; i<ret.length; i++)
            sum += ret[i];
        return sum;
    }
}