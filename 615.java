import java.util.LinkedList;

class Solution {
  /*
   * @param numCourses: a total of n courses
   * @param prerequisites: a list of prerequisite pairs
   * @return: true if can finish all courses or false
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      // Memory Limit Exceeded
      int[][] matrix = new int[numCourses][numCourses];
      int[] degree = new int[numCourses];
      
      for(int i=0; i<prerequisites.length; i++) {
          int from = prerequisites[i][1];
          int to = prerequisites[i][0];
          if (matrix[from][to] == 0)
              degree[to]++;
          matrix[from][to] = 1;
      }
      
      LinkedList<Integer> queue = new LinkedList<>();
      int count = 0;
      for (int i=0; i<numCourses; i++) {
          if (degree[i] == 0)
              queue.offer(i);
      }
      while (!queue.isEmpty()) {
          int from = queue.poll();
          count++;
          for (int i=0; i<numCourses; i++) {
              if (matrix[from][i] == 1) {
                  degree[i]--;
                  if (degree[i]==0)
                      queue.offer(i);
              }
          }
      }
      return count==numCourses;
  }
}
