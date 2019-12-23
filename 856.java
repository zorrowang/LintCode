public class Solution {
    /**
     * @param words1: a list of string
     * @param words2: a list of string
     * @param pairs: a list of string pairs
     * @return: return a boolean, denote whether two sentences are similar or not
     */
    public boolean isSentenceSimilarity(String[] words1, String[] words2, List<List<String>> pairs) {
        // write your code here
        if (words1 == null || words2 == null || words1.length != words2.length)
            return false;
        Map<String, Set<String>> map = new HashMap<>();
        for(List<String> p : pairs) {
            if (!map.containsKey(p.get(0)))
                map.put(p.get(0), new HashSet<String>());
            map.get(p.get(0)).add(p.get(1));
            if (!map.containsKey(p.get(1)))
                map.put(p.get(1), new HashSet<String>());
            map.get(p.get(1)).add(p.get(0));
        }
        
        for (int i=0; i<words1.length; i++) {
            String w1 = words1[i];
            String w2 = words2[i];
            
            if (w1.equals(w2) || (map.containsKey(w1) && map.get(w1).contains(w2)))
                continue;
            else
                return false;
        }
        return true;
    }
}