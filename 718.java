public class Solution {
    /**
     * @param A: string A to be repeated
     * @param B: string B
     * @return: the minimum number of times A has to be repeated
     */
    public int repeatedString(String A, String B) {
        // write your code here
        if (A==null || B==null) return -1;
        if (A.isEmpty() && B.isEmpty()) return 1;
        if (A.isEmpty()) return -1;
        if (B.isEmpty()) return 1;
        if (A.length()>B.length())
            if (A.contains(B))  return 1;
            else return -1;
        
        int ret = B.length() / A.length();
        String str = "";
        for (int i=0; i<ret; i++)
            str += A;
        if (str.contains(B))  return ret;
        str += A;
        if (str.contains(B))  return ret+1;
        str += A;
        if (str.contains(B))  return ret+2;
        return -1;
    }
}

