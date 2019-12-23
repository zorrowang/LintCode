public class Solution {
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    // Lintcode OOM
    public void wallsAndGates(int[][] rooms) {
        // write your code here
        if (rooms==null || rooms.length==0 || rooms[0].length==0)
            return;
        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();
        LinkedList<Integer> steps = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i=0; i<rooms.length; i++) {
            for (int j=0; j<rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    int curX = i, curY = j;
                    boolean[][] checked = new boolean[rooms.length][rooms[0].length];
                    xQueue.offer(i);
                    yQueue.offer(j);
                    steps.offer(0);
                    while(!xQueue.isEmpty()&&!yQueue.isEmpty()) {
                        int x = xQueue.poll();
                        int y = yQueue.poll();
                        int step = steps.poll();
                        rooms[x][y] = Math.min(rooms[x][y], step);
                        checked[x][y] = true;
                        for (int s=0; s<4; s++) {
                            int nx = x + dx[s];
                            int ny = y + dy[s];
                            if (nx<0 || nx>rooms.length-1 || ny<0 || ny>rooms[nx].length-1)
                                continue;
                            if (rooms[nx][ny] > 1 && !checked[nx][ny]) {
                                xQueue.offer(nx);
                                yQueue.offer(ny);
                                steps.offer(step+1);
                            }
                        }
                    }
                }
            }
        }
    }
}

