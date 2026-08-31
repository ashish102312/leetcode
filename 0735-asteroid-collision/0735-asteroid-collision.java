class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int a : asteroids) {
            boolean destory = false;
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    // stack asteroid is destroyed
                    stack.pop();
                }
                else if (stack.peek() == -a) {
                    // both are destroyed
                    stack.pop();
                    destory = true;
                    break;
                }
                else {
                    // current asteroid is destroyed
                    destory = true;
                    break;
                }
            }
            if (!destory) {
                stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            ans[i] = stack.pop();
        }
        return ans;
    }
}
