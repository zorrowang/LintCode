public class Solution {
    /**
     * @param N: The number of integers
     * @return: The number of beautiful arrangements you can construct
     */
    int count = 0;
    
    
    public int countArrangement(int N) {
        // Write your code here
        boolean[] used = new boolean[N+1];
        helper(N, 1, used);
        return count;
    }
    
    private void helper(int N, int pos, boolean[] used) {
        if (pos > N) {
            count++;
            return;
        }
        
        for (int i=1; i<=N; i++) {
            if (!used[i] && (pos%i==0 || i%pos==0)) {
                used[i] = true;
                helper(N, pos+1, used);
                used[i] = false;
            }
        }
    }
}

