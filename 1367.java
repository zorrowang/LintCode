public class Solution {
    /**
     * @param matrix : the martix
     * @return: the distance of grid to the police
     */
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public int[][] policeDistance(int[][] matrix ) {
        // Write your code here
        if (matrix == null || matrix.length==0) return null;
        int[][] ret = new int[matrix.length][matrix[0].length];
        LinkedList<Integer> xQueue = new LinkedList<Integer>();
        LinkedList<Integer> yQueue = new LinkedList<Integer>();
        
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    xQueue.offer(i);
                    yQueue.offer(j);
                    matrix[i][j] = -1;
                }
            }
        }
        
        LinkedList<Integer> queue1 = (LinkedList<Integer>)xQueue.clone();
        LinkedList<Integer> queue2 = (LinkedList<Integer>)yQueue.clone();
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            int x = queue1.poll();
            int y = queue2.poll();
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx<0 || nx>=matrix.length || ny<0 || ny>=matrix[nx].length || 
                    matrix[nx][ny] == -1)
                    continue;
                if (matrix[nx][ny] == 0) {
                    queue1.offer(nx);
                    queue2.offer(ny);
                    matrix[nx][ny] = matrix[x][y]==-1 ? 1 : matrix[x][y]+1;
                }
            }
        }
        
        while(!xQueue.isEmpty() && !yQueue.isEmpty()) {
            matrix[xQueue.poll()][yQueue.poll()] = 0;
        }
        return matrix;
    }
}