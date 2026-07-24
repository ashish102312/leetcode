class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int Max = 2048;
        boolean[][] dp = new boolean[4][Max];
        dp[0][0] = true;
        for(int val : nums){
            boolean[][] next = new boolean[4][Max];
            for(int i = 0; i<4; i++){
                System.arraycopy(dp[i],0,next[i],0,Max);
            }
            for(int cnt = 0; cnt<=3; cnt++){
                for(int xor = 0; xor<Max; xor++){
                    if(!dp[cnt][xor])continue;
                    for(int take =1; cnt+take <=3; take++){
                        int newXor = (take%2==0)?xor : (xor^val);
                        next[cnt+take][newXor] = true;
                    }
                }
            }
            dp = next;
        }
        int ans =0;
        for(boolean possible : dp[3]){
            if(possible)ans++;
        }
        return ans;
    }
}