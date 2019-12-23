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
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        if (intervals==null || intervals.size()==0) return true;
        Collections.sort(intervals, (i1, i2) -> i1.start - i2.start);
        for (int i=0; i<intervals.size()-1; i++) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i+1);
            if (!(i1.end <= i2.start || i2.end <= i1.start))
                return false;
        }
        return true;
    }
}

