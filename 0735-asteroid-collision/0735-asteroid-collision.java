class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids){
            boolean alive = true;
            while(!stack.isEmpty() && a<0 && stack.peek()>0){
                if(stack.peek() < -a){
                    //destroy the asteroids
                    stack.pop();
                }
                else if(stack.peek() == -a){
                    //both are destoryed;
                    stack.pop();
                    alive = false;
                    break;
                }else{
                    alive = false;
                    break;
                }
            }
            if(alive){
                stack.push(a);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = stack.size()-1 ; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}