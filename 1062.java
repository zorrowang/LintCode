public class Solution {
    /**
     * @param image: a 2-D array
     * @param sr: an integer
     * @param sc: an integer
     * @param newColor: an integer
     * @return: the modified image
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Write your code here
        boolean[][] check = new boolean[image.length][image[0].length];
        LinkedList<Integer> xQueue = new LinkedList<>();
        LinkedList<Integer> yQueue = new LinkedList<>();
        xQueue.offer(sr);
        yQueue.offer(sc);
        int color = image[sr][sc];
        image[sr][sc] = newColor;
        check[sr][sc] = true;
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx<0 || nx>=image.length || ny<0 || ny>=image[nx].length || check[nx][ny] || image[nx][ny] != color)
                    continue;
                check[nx][ny] = true;
                image[nx][ny] = newColor;
                xQueue.offer(nx);
                yQueue.offer(ny);
            }
        }
        return image;
    }
}