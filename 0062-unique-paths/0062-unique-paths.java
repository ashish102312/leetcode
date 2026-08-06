class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return path(m-1,n-1,dp);
    }
    int path(int row ,int col , int[][]dp){
        if(row == 0 || col == 0)return 1;
        if(dp[row][col] != 0){
            return dp[row][col];
        }
        dp[row][col] = path(row-1,col,dp) + path(row,col-1,dp);
        return dp[row][col];
    }
}