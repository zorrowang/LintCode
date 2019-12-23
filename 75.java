public class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        int start=0, end=A.length-1;
        
        while (start < end) {
            int mid = (start + end)/2;
            if (A[mid-1] < A[mid] && A[mid] > A[mid+1])
                return mid;
            else if (A[mid-1] < A[mid] && A[mid] < A[mid+1])
                start = mid+1;
            else
                end = mid;
        }
        return start;
    }
}