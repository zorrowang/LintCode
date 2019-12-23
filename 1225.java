public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the perimeter of the island
     */
    int ret = 0;
    public int islandPerimeter(int[][] grid) {
        // Write your code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count(grid, i, j, visited);
                    return ret;
                }
            }
        }
        return ret;
    }
    
    private void count(int[][] grid, int i, int j, boolean[][] visited) {
        if (i-1 < 0 || grid[i-1][j] == 0)   ret += 1;
        if (i+1 >= grid.length || grid[i+1][j] == 0)   ret += 1;
        if (j-1 < 0 || grid[i][j-1] == 0)   ret += 1;
        if (j+1 >= grid[i].length || grid[i][j+1] == 0)   ret += 1;
        visited[i][j] = true;
        
        if (i-1 >= 0 && grid[i-1][j]==1 && !visited[i-1][j])    count(grid, i-1, j, visited);
        if (i+1 < grid.length && grid[i+1][j]==1 && !visited[i+1][j])    count(grid, i+1, j, visited);
        if (j-1 >= 0 && grid[i][j-1]==1 && !visited[i][j-1])    count(grid, i, j-1, visited);
        if (j+1 < grid[i].length && grid[i][j+1]==1 && !visited[i][j+1])    count(grid, i, j+1, visited);
    }
}

// More elegant solution
public class Solution {
    /**
     * @param grid: a 2D array
     * @return: the perimeter of the island
     */
    public int islandPerimeter(int[][] grid) {
        // Write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
}