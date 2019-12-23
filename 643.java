public class Solution {
    /**
     * @param input: an abstract file system
     * @return: return the length of the longest absolute path to file
     */
    public int lengthLongestPath(String input) {
        // write your code here
        if (input==null || input.isEmpty()) return 0;
        String[] array = input.split("\n");
        LinkedList<Integer> stack = new LinkedList<>();
        int ret = 0;
        stack.push(array[0].length());
        int cur = 0;
        for (int i=1; i<array.length; i++) {
            int level = array[i].lastIndexOf("\t")+1;
            int len = array[i].length()-level;
            while(cur>=level) {
                stack.pop();
                cur--;
            }
            cur = level;
            int total = stack.isEmpty() ? len : stack.peek()+len+1;
            if (array[i].contains(".")) ret = Math.max(ret, total);
            stack.push(total);
        }
        return ret;
    }
}