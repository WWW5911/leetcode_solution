class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) return 0;
        int ans = 0, holding = 0, now = 0;
        for(int i = 1; i < prices.length; ++i){
            if(holding == 0 && prices[i]-prices[i-1] > 0){
                now = prices[i-1];
                holding = 1;
            }
            if(holding == 1)
                if(prices[i]-prices[i-1] < 0 ){
                    ans += now - prices[i-1];
                    holding = 0; 
                }else if(i == prices.length-1)
                    ans += now - prices[i];
        }
        return -ans;
    }
}