public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board==null || board.length==0) return;
        
        for (int i=0, j=0; i<board.length; i++)
            if (board[i][j] == 'O')
                helper(board, i, j);
        for (int i=0, j=board[0].length-1; i<board.length; i++)
            if (board[i][j] == 'O')
                helper(board, i, j);
        for (int i=0, j=0; j<board[i].length; j++)
            if (board[i][j] == 'O')
                helper(board, i, j);
        for (int i=board.length-1, j=0; j<board[i].length; j++)
            if (board[i][j] == 'O')
                helper(board, i, j);
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    private void helper(char[][] grid, int i, int j) {
        if (grid[i][j] == 'O') {
            grid[i][j] = 'T';
            for (int s=0; s<4; s++) {
                int x = i+dx[s];
                int y = j+dy[s];
                if (x<0 || x>grid.length-1 || y<0 || y>grid[x].length-1)
                    continue;
                helper(grid, x, y);
            }
        }
    }
}

