public class Solution {
    /**
     * @param asteroids: a list of integers
     * @return: return a list of integers
     */
    public int[] asteroidCollision(int[] asteroids) {
        // write your code here
        if (asteroids == null || asteroids.length==0)   return asteroids;
        LinkedList<Integer> stack = new LinkedList<>();
        for (int ast : asteroids) {
            if (stack.isEmpty() || ast > 0)
                stack.push(ast);
            else if (ast < 0) {
                boolean flag = false;
                while(!stack.isEmpty() && stack.peek()>0) {
                    int n = stack.peek();
                    if (n == -ast) {
                        stack.pop();  
                        flag = true;
                        break;
                    }
                    else if (n<-ast) {
                        stack.pop();
                        continue;
                    }
                    else if (n > -ast)
                        break;
                }
                if (flag)   continue;
                if (stack.isEmpty() || stack.peek()<0)
                    stack.push(ast);
            }
        }
        int[] ret = new int[stack.size()];
        for (int i=stack.size()-1; i>=0; i--)
            ret[i] = stack.pop();
        return ret;
    }
}