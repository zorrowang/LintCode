public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
    public boolean exist(char[][] board, String word) {
        // write your code here
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                visited[i][j] = true;
                if (helper(board, i, j, word, 0, visited))
                    return true;
                visited[i][j] = false;
            }
        }
        return false;
    }
    
    private boolean helper(char[][] board, int i, int j, String word, 
        int start, boolean[][] visited) {
        if (start == word.length()-1 && board[i][j]==word.charAt(start))
            return true;
        else if (start >= word.length()-1 || board[i][j]!=word.charAt(start))
            return false;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int s=0; s<4; s++) {
            int x = i+dx[s];
            int y = j+dy[s];
            if (x<0 || x>board.length-1 || y<0 || y>board[x].length-1 || visited[x][y])
                continue;
            visited[x][y] = true;
            if (helper(board, x, y, word, start+1, visited))
                return true;
            visited[x][y] = false;
        }
        return false;
    }
}