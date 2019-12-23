public class Solution {
    /**
     * @param grid: a 2d boolean array
     * @param k: an integer
     * @return: the number of Islands
     */
    public int numsofIsland(boolean[][] grid, int k) {
        // Write your code here
        if (grid==null || grid.length==0 || k<=0)
            return -1;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();
        int ret = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j]) {
                    xQueue.offer(i);
                    yQueue.offer(j);
                    grid[i][j] = false;
                    int cur = 0;
                    while (!xQueue.isEmpty()) {
                        int x = xQueue.poll();
                        int y = yQueue.poll();
                        
                        cur += 1;
                        for (int s=0; s<4; s++) {
                            int nx = x + dx[s];
                            int ny = y + dy[s];
                            if (nx<0 || ny<0 || nx>grid.length-1 || ny>grid[nx].length-1 || !grid[nx][ny])
                                continue;
                            xQueue.offer(nx);
                            yQueue.offer(ny);
                            grid[nx][ny] = false;
                        }
                    }
                    if (cur >= k)   ret++;
                }
            }
        }
        return ret;
    }
}

