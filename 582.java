public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    // OOM
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        List<String> ret = new ArrayList<>();
        if (s.length()==0)  return ret;
        return helper(s, 0, wordDict);
    }
    
    private List<String> helper(String s, int start, Set<String> dict) {
        List<String> ret = new ArrayList<>();
        if (dict.contains(s.substring(start)))  ret.add(s.substring(start));
        for (int i=start+1; i<s.length(); i++) {
            String sub = s.substring(start, i);
            if (dict.contains(sub)) {
                List<String> list = helper(s, i, dict);
                if (list.size() != 0) {
                    for (String str : list)
                        ret.add(sub + " " + str);
                }
            }
        }
        return ret;
    }
}