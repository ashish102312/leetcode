class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int small = 0;
        int equal = 0;
        for(int num : nums){
            if(num < target){
                small++;
            }
            else if(num == target){
                equal++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = small; i< small + equal; i++){
            res.add(i);
        }
        return res;
    }
}