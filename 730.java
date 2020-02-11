public class Solution {
  /**
   * @param n: the given number
   * @return: Sum of elements in subsets
   */
  public int subSum(int n) {
      // write your code here
      if (n <= 0) return 0;
      int totalCount = ((int)Math.pow(2, n) - 2)/2 + 1;
      int sum = (1+n)*n/2;
      return sum * totalCount;
  }
}