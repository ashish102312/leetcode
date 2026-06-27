class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> tree = new TreeSet<>();
        for(int i = 0; i<nums.length; i++){
            Long candy = tree.ceiling((long) nums[i] - valueDiff);
            if(candy != null && candy <= (long) nums[i] + valueDiff){
                return true;
            }
            tree.add((long)nums[i]);
            if(i>= indexDiff){
                tree.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }
}