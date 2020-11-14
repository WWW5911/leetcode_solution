class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int leng = costs.length, half = leng>>1, ans = 0;
        int [] arr = new int[leng];
        for(int i = 0; i < leng; ++i){
            arr[i] = costs[i][0] - costs[i][1];
            ans += costs[i][1];
        }
        Arrays.sort(arr);
        for(int i = 0; i < half; ++i)
            ans += arr[i];
        return ans;
    }
}