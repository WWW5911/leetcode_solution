class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int index = 0, temp = 0;
        int [] dp = new int[30];
        for(int i = days[0]; i <= days[days.length-1]; ++i ){
            if(i != days[index])
                dp[i%30] = dp[(i-1)%30];
            else{
                temp = dp[(i-1)%30] + costs[0];
                temp = dp[max((i-7)%30, 0)] + costs[1] < temp ? dp[max((i-7)%30, 0)] + costs[1] : temp;
                dp[i%30] = dp[max((i-30)%30, 0)] + costs[2] < temp ? dp[max((i-30)%30, 0)] + costs[2] : temp ;
                ++index;
            }
        }
        return dp[days[days.length-1]%30];
    }
    public int max(int a, int b){
        return a > b ? a: b;
    }
}