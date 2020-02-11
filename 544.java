public class Solution {
  /**
   * @param nums: an integer array
   * @param k: An integer
   * @return: the top k largest numbers in array
   */
  public int[] topk(int[] nums, int k) {
      // write your code here
      PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>((x, y) -> x-y);
      
      for (int i=0; i<nums.length; i++) {
          if (minQueue.size() < k) {
              minQueue.offer(nums[i]);
          } else if (minQueue.peek() < nums[i]) {
              minQueue.poll();
              minQueue.offer(nums[i]);
          }
      }
      
      int[] ret = new int[k];
      for (int i=k-1; i>=0; i--) {
          ret[i] = minQueue.poll();
      }
      return ret;
  }
}