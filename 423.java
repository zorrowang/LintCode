public class Solution {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // write your code here
        if (s==null && s.isEmpty()) return true;
        LinkedList<Character> stack = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || !isMatch(stack.peek(), c))
                stack.push(c);
            else if (isMatch(stack.peek(), c))
                stack.pop();
        }
        return stack.isEmpty();
    }
    
    private boolean isMatch(char c1, char c2) {
        if (c1=='(' && c2==')') return true;
        if (c1=='[' && c2==']') return true;
        if (c1=='{' && c2=='}') return true;
        return false;
    }
}