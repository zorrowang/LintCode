public class Solution {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<B.length; i++)
            map.put(B[i], i);
        int[] ret = new int[B.length];
        
        for(int i=0; i<A.length; i++)
            ret[i] = map.get(A[i]);
        return ret;
    }
}