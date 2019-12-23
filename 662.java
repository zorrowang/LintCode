/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int start = 0;
        
        while (start < n) {
            int mid = start + (n-start) / 2;
            int ret = guess(mid);
            if (ret==0)
                return mid;
            else if (ret == -1)
                n = mid-1;
            else
                start = mid+1;
        }
        return start;
    }
}