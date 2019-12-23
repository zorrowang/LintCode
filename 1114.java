public class Solution {
    /**
     * @param price: List[int]
     * @param special: List[List[int]]
     * @param needs: List[int]
     * @return: return an integer
     */
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // write your code here
        // OOM
        int[] dp = new int[(int)Math.pow(10, price.size())];
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for (int i=0; i<price.size(); i++) {
            int n = (int)Math.pow(10, price.size()-i-1);
            if (dp[n]==0 || dp[n] > price.get(i)) {
                dp[n] = price.get(i);
                map.put(n, dp[n]);
            }
            sum += price.get(i);
        }
        if (sum == 0)   return 0;
        
        for (List<Integer> list: special) {
            int n = 0;
            for (int i=0; i<list.size()-1; i++)  
                n = n*10 + list.get(i);
            if (dp[n]==0 || dp[n] > list.get(list.size()-1)) {
                dp[n] = list.get(list.size()-1);
                map.put(n, dp[n]);
            }
        }
        
        int need = 0;
        for (int i=0; i<needs.size(); i++)
            need = need*10 + needs.get(i);
        for (int i=1; i<=need; i++) {
            if (map.containsKey(i))  continue;
            int min = Integer.MAX_VALUE;
            for (int key : map.keySet()) {
                int n = i-key;
                if (n > 0)
                    min = Math.min(min, dp[n] + map.get(key));
            }
            dp[i] = min;
        }
        return dp[need];
    }
}