class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int start = 0, end = matrix.length * matrix[0].length, idx = 0, row = matrix[0].length ;
        while(start <= end){
            idx = start + (end - start)/2;
            if(idx/row >= matrix.length ) break;
            if(matrix[idx / row][idx % row] > target) end = idx-1;
            else if( matrix[idx / row][idx % row] < target ) start = idx+1;
            else return true;
        }
        return false;
    }
}