class Solution {

    int MOD = 1_000_000_007;

    int[] nums;
    int n;

    Integer[][][] memo;

    public int subsequencePairCount(int[] nums) {

        this.nums = nums;
        n = nums.length;

        memo = new Integer[n + 1][201][201];

        return dfs(0, 0, 0);
    }

    int dfs(int idx, int g1, int g2) {

        if (idx == n) {

            if (g1 != 0 && g1 == g2)
                return 1;

            return 0;
        }

        if (memo[idx][g1][g2] != null)
            return memo[idx][g1][g2];

        long ans = 0;

        // Ignore
        ans += dfs(idx + 1, g1, g2);

        // Put in first subsequence
        int ng1 = (g1 == 0) ? nums[idx] : gcd(g1, nums[idx]);
        ans += dfs(idx + 1, ng1, g2);

        // Put in second subsequence
        int ng2 = (g2 == 0) ? nums[idx] : gcd(g2, nums[idx]);
        ans += dfs(idx + 1, g1, ng2);

        ans %= MOD;

        return memo[idx][g1][g2] = (int) ans;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}