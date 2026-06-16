class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candt1 = 0;
        int candt2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num == candt1)count1++;
            else if(num == candt2)count2++;
            else if(count1 == 0){
                candt1 = num;
                count1 = 1;
            }else if(count2 == 0){
                candt2 = num;
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == candt1)count1++;
            else if(num == candt2)count2++;
        }
        List<Integer> ans = new ArrayList<>();
        int limit = nums.length/3;
        if(count1 > limit)ans.add(candt1);
        if(count2 > limit)ans.add(candt2);

        return ans;
    }
}