public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] ret = new int[length];
        for (int[] update: updates) {
            if (update[0] < 0 || update[1] > length-1)
                return null;
            helper(ret, update);
        }
        return ret;
    }
    
    private void helper(int[] orig, int[] update) {
        for (int i=update[0]; i<=update[1]; i++) {
            orig[i] += update[2];
        }
    }
}

public class Solution {
    /**
     * @param length: the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] ret = new int[length];
        for (int[] update: updates) {
            if (update[0] < 0 || update[1] > length-1)
                return null;
            ret[update[0]] += update[2];
            if (update[1] < length-1)
                ret[update[1]+1] -= update[2];
        }
        
        int sum = 0;
        for (int i=0; i<length; i++) {
            sum += ret[i];
            ret[i] = sum;
        }
        return ret;
    }
}