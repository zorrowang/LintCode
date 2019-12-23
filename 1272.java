public class Solution {
    /**
     * @param matrix: List[List[int]]
     * @param k: a integer
     * @return: return a integer
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        boolean[][] checked = new boolean[matrix.length][matrix[0].length];
        helper(matrix, 0, 0, k, list, checked);
        Collections.sort(list);
        return list.get(k-1);
    }
    
    private void helper(int[][] matrix, int i, int j, int k, List<Integer> list, boolean[][] checked) {
        if (checked[i][j])  return;
        
        list.add(matrix[i][j]);
        checked[i][j] = true;
        if (k == 1) {
            return;
        }
        
        if (i < matrix.length-1)    helper(matrix, i+1, j, k, list, checked);
        if (j < matrix[i].length-1)    helper(matrix, i, j+1, k, list, checked);
    }
}