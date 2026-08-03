class Solution {
    public int fib(int n) {
        if(n<=1)return n;
        int prev = 0;
        int prev1 = 1;

        for(int i = 2; i<=n; i++){
            int temp = prev + prev1;
            prev = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}