public class Solution {
    /**
     * @param preorder: a string
     * @return: return a bool
     */
    public boolean isValidSerialization(String preorder) {
        // write your code here
        if (preorder == null || preorder.isEmpty())
            return false;
        String[] strs = preorder.split(",");
        LinkedList<String> s = new LinkedList<>();
        for (String str : strs) {
            s.add(str);
            while(s.size()>=3 && s.get(s.size()-1).equals("#") && 
                s.get(s.size()-2).equals("#") && !s.get(s.size()-3).equals("#")) {
                    s.remove(s.size()-1);
                    s.remove(s.size()-1);
                    s.remove(s.size()-1);
                    s.add("#");
            }
        }
        return s.size()==1 && s.get(0).equals("#");
    }
}