public class Solution {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        // Write your code here
        if(parse(inputA).equals(parse(inputB)))
            return "YES";
        else
            return "NO";
    }
    
    private String parse(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '<') {
                if (!stack.isEmpty()) {
                  stack.pop();
                }
            }
            else
                stack.push(ch);
        }
        StringBuilder builder = new StringBuilder();
        for(char ch : stack)
            builder.append(ch);
        return builder.toString();
    }
}