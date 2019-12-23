public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: The list of grid coordinates
     */
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // write your code here
        if (matrix == null) return null;
        boolean[][] p = new boolean[matrix.length][matrix[0].length];
        boolean[][] a = new boolean[matrix.length][matrix[0].length];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();
        for (int i=0, j=0; j<matrix[i].length; j++) {
            p[i][j] = true;
            xQueue.offer(i);
            yQueue.offer(j);
        }
        for (int i=1, j=0; i<matrix.length; i++) {
            p[i][j] = true;
            xQueue.offer(i);
            yQueue.offer(j);
        }
        while (!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx>=matrix.length || ny>=matrix[nx].length ||
                    p[nx][ny] || matrix[nx][ny]<matrix[x][y])
                    continue;
                p[nx][ny] = true;
                xQueue.offer(nx);
                yQueue.offer(ny);
            }
        }
        
        xQueue = new LinkedList<>();
        yQueue = new LinkedList<>();
        for (int i=matrix.length-1, j=0; j<matrix[i].length; j++) {
            a[i][j] = true;
            xQueue.offer(i);
            yQueue.offer(j);
        }
        for (int i=matrix.length-2, j=matrix[i].length-1; i>=0; i--) {
            a[i][j] = true;
            xQueue.offer(i);
            yQueue.offer(j);
        }
        while (!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx>=matrix.length || ny>=matrix[nx].length ||
                    a[nx][ny] || matrix[nx][ny]<matrix[x][y])
                    continue;
                a[nx][ny] = true;
                xQueue.offer(nx);
                yQueue.offer(ny);
            }
        }
        
        List<List<Integer>> ret = new ArrayList<>();
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (p[i][j] && a[i][j]) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(i); l.add(j);
                    ret.add(l);
                }
            }
        }
        return ret;
    }
}