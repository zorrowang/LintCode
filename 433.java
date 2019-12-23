public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        int ret = 0;
        if (grid==null || grid.length==0)
            return ret;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j]) {
                    ret++;
                    helper(grid, i, j);
                }
            }
        }
        return ret;
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private void helper(boolean[][] grid, int i, int j) {
        if (grid[i][j]) {
            grid[i][j] = false;
            for (int s=0; s<4; s++) {
                int x = i + dx[s];
                int y = j + dy[s];
                if (x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1)
                    continue;
                helper(grid, x, y);
            }
        }
    }
}

