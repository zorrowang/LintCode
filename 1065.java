class MyCalendar {
    
    class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    List<Interval> intervals;
    public MyCalendar() {
        intervals = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        Interval inter = new Interval(start, end);
        for (Interval i : intervals) {
            if (isOverlapped(i, inter))
                return false;
        }
        intervals.add(inter);
        return true;
    }
    
    private boolean isOverlapped(Interval i1, Interval i2) {
        return !(i1.start >= i2.end || i2.start >= i1.end);
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */