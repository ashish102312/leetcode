class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int island = 0;

        for(int r = 0; r<row; r++){
            for(int c = 0; c<col; c++){
                if(grid[r][c] == '1'){
                    island++;

                    dfs(grid,r,c);
                }
            }
        }
        return island;
    }
    private void dfs(char[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;

        if(r<0 || c<0 || r>=row || c>=col || grid[r][c] == '0')return;

        grid[r][c] = '0';

        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);

    }
}