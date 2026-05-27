class Solution {
    public void rotate(int[] nums, int k) {
       int n = nums.length;

       k= k%n;
       //1. reverse whole array
       rev(nums,0,n-1);
       //2. reverse the k elemets
       rev(nums,0,k-1);
       //3. reverse the remaining one 
       rev(nums,k,n-1);
    }
    private void rev(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}