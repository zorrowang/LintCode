public class Solution {
    /**
     * @param grid: a list of lists of integers
     * @return: return an integer, denote the number of distinct islands
     */
    
    public int numberofDistinctIslands(int[][] grid) {
        // write your code here
        if (grid==null || grid.length==0)   return -1;
        Set<String> ret = new HashSet<String>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    Set<String> set = new HashSet<>();
                    helper(grid, i, j, i, j, set);
                    ret.add(set.toString());
                }
            }
        }
        return ret.size();
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private void helper(int[][] grid, int i, int j, int orgI, int orgJ, Set<String> set) {
        if (grid[i][j] == 1) {
            String str = (i-orgI) + "_" + (j-orgJ);
            set.add(str);
            grid[i][j] = 0;
            for (int s = 0; s<4; s++) {
                int x = i + dx[s];
                int y = j + dy[s];
                if (x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1)
                    continue;
                helper(grid, x, y, orgI, orgJ, set);
            }
        }
    }
}

