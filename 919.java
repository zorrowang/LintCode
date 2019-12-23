/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if (intervals==null || intervals.size()==0) return -1;
        Collections.sort(intervals, (i1, i2)->i1.start - i2.start);
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(intervals.get(0).end);
        for (int i=1; i<intervals.size(); i++) {
            if (intervals.get(i).start > queue.peek())
                queue.poll();
            queue.offer(intervals.get(i).end);
        }
        return queue.size();
    }
}

