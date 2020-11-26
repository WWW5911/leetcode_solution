class Solution {
    public int search(int[] nums, int target) {
        int mid = nums.length/2, l = 0, r = nums.length-1;
        while( l <= r ){
            if(nums[(mid = (r + l)/2)] == target) return mid;
            if(nums[mid] < nums[r]){//中間到右為升序
                if(nums[mid] < target && nums[r] >= target) l = mid+1;
                else r = mid-1;
            }else{//左邊到中間為升序
                if(nums[mid] > target && nums[l] <= target) r = mid-1;
                else l = mid+1;
            }
            
        }
        return -1;
    }
}

/*
知道用二分搜後80%抄
思路 二分搜
由於他是從一定位置開始分為兩個升序序列
增加效率 使用中間為分隔點
如果中間的小於最右的 代表中到右是升序
    如果在這個情況下中間比目標小 而且右邊比目標大於等於
        代表答案確定在中間到右的區間 所以移動左指標到中間
    如果否 代表中間太大 或是目標根本不再這邊 所以右指標移動到中間
左邊同樣如此
如果l比r大了 代表就是沒找到
*/