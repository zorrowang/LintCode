public class Solution {
    /**
     * @param s: the given string
     * @return: all the possible states of the string after one valid move
     */
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        ArrayList<String> ret = new ArrayList<>();
        if (s == null || s.length()==0)
            return ret;
        char[] array = s.toCharArray();
        for(int i=0; i<s.length()-1; i++) {
            if(s.charAt(i)=='+' && s.charAt(i+1)=='+') {
                char[] clone = array.clone();
                clone[i]='-';
                clone[i+1]='-';
                ret.add(new String(clone));
            }
        }
        return ret;
    }
}