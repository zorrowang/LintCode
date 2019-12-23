public class Solution {
    /**
     * @param strs: the given array of strings
     * @return: The anagrams which have been divided into groups
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        // write your code here
        List<List<String>> ret = new ArrayList<>();
        if (strs==null || strs.length==0)   return ret;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String s = new String(array);
            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }
        for (String s : map.keySet())
            ret.add(map.get(s));
        return ret;
    }
}