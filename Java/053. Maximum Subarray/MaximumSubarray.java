class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = nums[0] > 0 ? nums[0] : 0;
        for(int i = 1; i < nums.length; ++i){
            cur += nums[i];
            if(cur > max) max = cur;
            if(cur < 0) cur = 0;
        }
        return max;
    }
}