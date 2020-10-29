class Solution {
    public int[][] merge(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for(int i = 0; i < intervals.length-1; ++i)
            if(intervals[i][1] >= intervals[i+1][0]){
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = intervals[i][1] > intervals[i+1][1] ?intervals[i][1] : intervals[i+1][1];
                intervals[i][1] = intervals[i][0]-1;
                count++;
            }
        int [][] ans = new int[intervals.length-count][2];
        for(int i = 0, j = 0; i < intervals.length; ++i){
            if(intervals[i][1] < intervals[i][0]) continue;
            ans[j][0] = intervals[i][0];
            ans[j++][1] = intervals[i][1];
        }
        return ans;
    }
}