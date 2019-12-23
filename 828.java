public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        // write your code here
        if (pattern==null || teststr==null) return false;
        String[] strs = teststr.split(" ");
        if (pattern.length() != strs.length)
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i=0; i<pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String s = map.get(pattern.charAt(i));
                if (!s.equals(strs[i]))
                    return false;
            } else if (map.containsValue(strs[i])) { 
                return false;
            } else {
                map.put(pattern.charAt(i), strs[i]);
            }
        }
        return true;
    }
}