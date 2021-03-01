class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0, tmp = 0;
        for(int i = 0; i < grid.length; ++i){
            while(tmp < grid[i].length && grid[i][tmp] >= 0) tmp++;
            while(tmp != 0 && grid[i][tmp-1] < 0) tmp -= 1;
            sum += grid[0].length -tmp;
        }
        return sum;
    }
}