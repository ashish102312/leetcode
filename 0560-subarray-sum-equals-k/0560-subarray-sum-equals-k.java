class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int l = 0; l<nums.length; l++){
            int sum = 0;
            for(int r = l; r<nums.length; r++){
                sum += nums[r];
                if(sum == k)count++;
            }
        }
        return count;
    }
}