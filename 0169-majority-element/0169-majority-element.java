class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candy = 0;
        
        for(int num : nums){
            if(count == 0){
                candy = num;
            }
            if(candy == num){
                count++;
            }else{
                count--;
            }
        }
        return candy;
    }
}