// class Solution {
//     public int missingNumber(int[] nums) {
//     Arrays.sort(nums);
//         for(int i = 0; i<nums.length; i++){
//             if(nums[i] != i){
//                 return i;
//             }
//         }
//         return nums.length;
//     }
// }

//follow up 
class Solution{
    public int missingNumber(int[] nums){
        int n = nums.length;
        int expected = n *(n+1)/2;
        int real = 0;
        for(int num: nums){
            real += num;
        }
        return expected - real;
    }
}