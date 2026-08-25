class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int multi = k;
        while(set.contains(multi)){
            multi += k;
        }
        return multi;
    }
}