class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i<n-2; i++){
            if(i>0 && nums[i] == nums[i-1])continue;
            int l = i+1;
            int k = n-1;
            while(l<k){
                int sum = nums[i]+nums[k]+nums[l];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[k]));
                    while(l<k && nums[l]== nums[l+1])l++;
                    while(l<k && nums[k]== nums[k-1])k--;
                    l++;
                    k--;
                }else if(sum>0)k--;
                else l++;
            }
        }
        return res;
    }
}