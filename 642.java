public class MovingAverage {
    Deque<Integer> deque;
    int cap;
    int cur;
    int sum;
    /*
    * @param size: An integer
    */public MovingAverage(int size) {
        // do intialization if necessary
        this.deque = new ArrayDeque<>();
        this.cap = size;
        this.cur = 0;
        this.sum = 0;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        // write your code here
        if (cur == cap) {
            sum -= deque.removeFirst();
            cur--;
        }
        deque.offer(val);
        sum += val;
        cur++;
        return (double)sum/cur;
    }
}