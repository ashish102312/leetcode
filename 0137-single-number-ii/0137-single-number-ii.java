class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int bit =0 ; bit<32; bit++){
            int sum = 0;
            for(int num : nums){
                if(((num >> bit) & 1) ==1){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                result |= (1<<bit);
            }
        }
        return result ;
    }
}