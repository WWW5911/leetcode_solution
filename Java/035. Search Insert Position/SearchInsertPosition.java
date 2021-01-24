class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length, mid = (l + r) /2;
        if(nums[0] > target) return 0;
        if(nums[r-1] < target) return r;
        while(l <= r){
            if(nums[mid] == target || (nums[mid] > target && nums[mid-1] < target) ) return mid;
            if(nums[mid] > target) r = mid;
            else l = mid;
            mid = (r+l)/2;
        }
        return mid;
    }
}