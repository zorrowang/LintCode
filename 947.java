public class Solution {
    /**
     * @param matrix: a 0-1 matrix
     * @return: return a matrix
     */
    class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int[][] updateMatrix(int[][] matrix) {
        // write your code here
        if (matrix==null || matrix.length==0)
            return matrix;
        
        LinkedList<Pair> queue = new LinkedList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = Integer.MAX_VALUE;
                else
                    queue.offer(new Pair(i, j));
            }
        }
        
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            for (int i=0; i<dx.length; i++) {
                int x = p.x + dx[i];
                int y = p.y + dy[i];
                if (x<0||x>=matrix.length||y<0||y>=matrix[x].length)
                    continue;
                if (matrix[x][y] > matrix[p.x][p.y] + 1) {
                    matrix[x][y] = matrix[p.x][p.y] + 1;
                    queue.offer(new Pair(x, y));
                }
            }
        }
        return matrix;
    }
}