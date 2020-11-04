class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int [] index = new int[matrix.length+1];
        int max_col = 1, count = 0;
        while(count <= k){
            int min = (int)1e10, tmp = 0;
            for(int i = 0; i <= max_col; ++i){
                if(index[i] >= matrix[0].length || i >= matrix.length) continue;
                if(min > matrix[i][index[i]]){
                    tmp = i;
                    min = matrix[i][index[i]];
                }
            }
            if(tmp == max_col && max_col < matrix.length) ++max_col;
            ++index[tmp];
            if(index[tmp] > matrix[0].length) ++max_col;
            if(++count == k) return min;
        }
        return 0;
    }
}