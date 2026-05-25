class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];

        //conver string to in
        for(int i = 0; i<nums.length; i++){
            arr[i]= String.valueOf(nums[i]);
        }
        //custom sorting
        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));

        //edge case
        if(arr[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s :arr){
            sb.append(s);
        }
        return sb.toString();
    }
}