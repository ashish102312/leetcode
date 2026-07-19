class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new LinkedList<>();

        for(int right = 0; right<n; right++){
            while(!dq.isEmpty() && dq.peekFirst() <= right - k){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[right]){
                dq.pollLast();
            }
            dq.addLast(right);
            if(right >= k-1){
                result[right-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}