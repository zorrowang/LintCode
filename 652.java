public class Solution {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    // OOM in leetcode
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        // ret.add(new ArrayList<Integer>());
        int root = (int)Math.sqrt(n);
        if (root == 1) return ret;
        for (int i=2; i<=root; i++) {
            if (n%i == 0) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                list.add(n/i);
                ret.add(list);
                List<List<Integer>> t = getFactors(n/i);
                for (int j=0; j<t.size(); j++) {
                    if (t.get(j).get(0) >= i) {
                        t.get(j).add(0, i);
                        ret.add(t.get(j));
                    }
                }
            }
        }
        return ret;
    }
}