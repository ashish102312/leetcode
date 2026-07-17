class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;
        for (int x : nums) max = Math.max(max, x);
        int[] freq = new int[max + 1];
        for (int x : nums) freq[x]++;
        long[] exact = new long[max + 1];
        // Count pairs whose GCD is exactly g
        for (int g = max; g >= 1; g--) {
            long cnt = 0;
            for (int multiple = g; multiple <= max; multiple += g) {
                cnt += freq[multiple];
            }
            long pairs = cnt * (cnt - 1) / 2;
            for (int multiple = g * 2; multiple <= max; multiple += g) {
                pairs -= exact[multiple];
            }
            exact[g] = pairs;
        }
        // Prefix counts
        long[] prefix = new long[max + 1];
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1] + exact[i];
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            long target = queries[i];
            int lo = 1, hi = max;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (prefix[mid] > target)
                    hi = mid;
                else
                    lo = mid + 1;
            }
            ans[i] = lo;
        }
        return ans;
    }
}