public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: return an integer
     */
    public int repeatedStringMatch(String A, String B) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while(sb.length() < B.length()) {
            sb.append(A);
            cnt++;
        }
        if (sb.toString().contains(B))  return cnt;
        if (sb.append(A).toString().contains(B))  return ++cnt;
        return -1;
    }
}