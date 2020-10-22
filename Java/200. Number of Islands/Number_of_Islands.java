class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[i].length; ++j){
                if(grid[i][j] != '0') ans += dfs(grid, i, j) != null ? 1:0;
            }
        return ans;
    }
    char[][] dfs(char[][] grid, int index1, int index2){
        grid[index1][index2] = '0';
        if(grid[index1 -1 >= 0 ? index1 -1 : 0 ][index2] != '0') grid = dfs(grid, index1 -1 >= 0 ? index1-1 : 0, index2 );
        if(grid[index1 +1 < grid.length ? index1+1 : grid.length -1 ][index2] != '0') grid = dfs(grid, index1 +1 < grid.length ? index1+1 : grid.length -1 , index2 );
        if(grid[index1][index2 -1 >= 0 ? index2 -1 : 0 ] != '0') grid = dfs(grid, index1, index2 -1 >= 0 ? index2 -1 : 0 );
        if(grid[index1][index2 +1 < grid[0].length ? index2 +1 : grid[0].length -1 ] != '0') grid = dfs(grid, index1, index2 +1 < grid[0].length ? index2 +1 : grid[0].length -1 );
        return grid;
    }
}