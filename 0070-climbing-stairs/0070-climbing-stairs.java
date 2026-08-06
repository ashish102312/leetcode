class Solution {
    public int climbStairs(int n) {
        if(n<=2)return n;
        int prev = 1;
        int prev1 = 2;
        for(int i = 3; i<=n; i++){
        int temp = prev + prev1;
        prev = prev1;
        prev1 = temp;
        }
        return prev1;
    }
}