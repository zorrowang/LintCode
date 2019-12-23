public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> ret = new ArrayList<>();
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
        for (String s : map.keySet()) {
            if (map.get(s).size()>1)
                ret.addAll(map.get(s));
        }
        return ret;
    }
}