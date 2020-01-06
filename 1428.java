public class Solution {
    /**
     * @param rooms: a list of keys rooms[i]
     * @return: can you enter every room
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Write your code here
        if (rooms == null || rooms.size() == 0) return true;
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        visited.add(0);
        for(int i=0; i<rooms.get(0).size(); i++)
            queue.offer(rooms.get(0).get(i));
        
        while (!queue.isEmpty()) {
            int room = queue.poll();
            if (!visited.contains(room)) {
                visited.add(room);
                for(int i=0; i<rooms.get(room).size(); i++)
                    queue.offer(rooms.get(room).get(i));
            }
        }
        
        return visited.size() == rooms.size();
    }
}