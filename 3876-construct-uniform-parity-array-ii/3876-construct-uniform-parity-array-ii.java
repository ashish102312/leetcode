class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = nums1[0];
        int odd = 0;
        for(int z : nums1){
            min = Math.min(min,z);
            odd |= z & 1;
        }
        return (min & 1 )==odd;
    }
}