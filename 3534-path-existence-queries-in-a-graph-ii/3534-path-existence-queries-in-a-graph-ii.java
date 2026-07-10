import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        int[] component = new int[n];
        int[] position = new int[n];

        int id = 0;
        component[arr[0][1]] = 0;
        position[arr[0][1]] = 0;

        for (int i = 1; i < n; i++) {

            if (arr[i][0] - arr[i - 1][0] > maxDiff)
                id++;

            component[arr[i][1]] = id;
            position[arr[i][1]] = i;
        }

        int[] next = new int[n];

        int r = 0;

        for (int l = 0; l < n; l++) {

            while (r + 1 < n && arr[r + 1][0] - arr[l][0] <= maxDiff)
                r++;

            next[l] = r;
        }

        int LOG = 18;

        int[][] up = new int[LOG][n];

        for (int i = 0; i < n; i++)
            up[0][i] = next[i];

        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int u = queries[q][0];
            int v = queries[q][1];

            if (u == v) {
                ans[q] = 0;
                continue;
            }

            if (component[u] != component[v]) {
                ans[q] = -1;
                continue;
            }

            int left = position[u];
            int right = position[v];

            if (left > right) {
                int t = left;
                left = right;
                right = t;
            }

            int steps = 0;

            for (int k = LOG - 1; k >= 0; k--) {

                if (up[k][left] < right) {
                    left = up[k][left];
                    steps += (1 << k);
                }
            }

            ans[q] = steps + 1;
        }

        return ans;
    }
}