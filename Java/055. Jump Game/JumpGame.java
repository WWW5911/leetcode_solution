class Solution {
    public boolean canJump(int[] nums) {
        int index = nums.length-1;
        while(index != 0){
            boolean flag = false;
            for(int i = 1; i <= index; ++i ){
                if(nums[index-i] >= i){
                    flag = true;
                    index -= i;
                    break;
                }
            }
            if(!flag ) return false;
        }
        return true;
    }
}