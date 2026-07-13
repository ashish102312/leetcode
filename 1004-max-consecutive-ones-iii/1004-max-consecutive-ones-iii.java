class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0;
        int n = nums.length;
        int left = 0;
        int maxAns = 0;
        for(int right = 0; right<n; right++){
            if(nums[right] == 0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left] == 0){
                    zeroCount--;
                }
                left++;
            }
            maxAns = Math.max(maxAns, right-left+1);
        }
        return maxAns;
    }
}