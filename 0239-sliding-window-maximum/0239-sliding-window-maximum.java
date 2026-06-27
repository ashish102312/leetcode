class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[ n - k+1];
        Deque<Integer> dq = new ArrayDeque<>(); 
        int index =0;

        for(int i = 0 ; i<n; i++){
            //remove indec outside the window 
            while(!dq.isEmpty() && dq.peekFirst() <= i -k){
                dq.pollFirst();
            }
            //remove smaller elemenet from the back
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            //add current index
            dq.offerLast(i);
            //check once window is create
            if(i >= k-1){
                ans[index++] = nums[dq.peekFirst()];
            }
        } 
        return ans;
    }
}