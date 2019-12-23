public class Solution {
    /**
     * @param moves: a sequence of its moves
     * @return: if this robot makes a circle
     */
    public boolean judgeCircle(String moves) {
        // Write your code here
        if (moves==null || (moves.length()&1) == 1)
            return false;
        int[] cnt = new int[26];
        for (int i=0; i<moves.length(); i++) {
            cnt[moves.charAt(i)-'A']+=1;
        }
        return cnt['U'-'A']==cnt['D'-'A'] && cnt['L'-'A']==cnt['R'-'A'];
    }
}