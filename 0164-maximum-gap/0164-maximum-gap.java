class Solution {

    public int maximumGap(int[] nums) {

        if (nums.length < 2)
            return 0;

        radixSort(nums);

        int ans = 0;

        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, nums[i] - nums[i - 1]);
        }

        return ans;
    }

    private void radixSort(int[] nums) {

        int max = 0;

        for (int x : nums)
            max = Math.max(max, x);

        int exp = 1;

        while (max / exp > 0) {

            countingSort(nums, exp);

            exp *= 10;
        }
    }

    private void countingSort(int[] nums, int exp) {

        int n = nums.length;

        int[] output = new int[n];

        int[] count = new int[10];

        // Count frequency
        for (int num : nums) {

            int digit = (num / exp) % 10;

            count[digit]++;
        }

        // Prefix Sum
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build output (right to left for stability)
        for (int i = n - 1; i >= 0; i--) {

            int digit = (nums[i] / exp) % 10;

            output[count[digit] - 1] = nums[i];

            count[digit]--;
        }

        // Copy back
        System.arraycopy(output, 0, nums, 0, n);
    }
}