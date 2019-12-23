public class Solution {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        // Write your code here
        if (str==null || str.length()==0)   return null;
        
        ArrayList<Integer[]> list = new ArrayList<>();
        char cur = str.charAt(0);
        int cnt = 1;
        for (int i=1; i<str.length(); i++) {
            if (cur == str.charAt(i)) {
                cnt++;
            } else {
                if (cnt > 2) {
                    list.add(new Integer[]{i-cnt, i-1});
                }
                cur = str.charAt(i);
                cnt = 1;
            }
        }
        
        int extra = cnt > 2 ? 1 : 0;
        int[][] ret = new int[list.size()+extra][2];
        for (int i=0; i<list.size(); i++) {
            ret[i][0] = list.get(i)[0];
            ret[i][1] = list.get(i)[1];
        }
        if (extra > 0) {
            ret[ret.length-1][0] = str.length()-cnt;
            ret[ret.length-1][1] = str.length()-1;
        }
        return ret;
    }
}