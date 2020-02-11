public class Solution {
  /**
   * @param n: a non-negative integer
   * @return: the total number of full staircase rows that can be formed
   */
  public int arrangeCoins(int n) {
    // Write your code here
    long t = (long) n;
    t = t * 2;
    long s = (long) Math.sqrt(t);
    long count = (1 + s) * s / 2;
    return count > n ? (int) (s - 1) : (int) s;
  }
}