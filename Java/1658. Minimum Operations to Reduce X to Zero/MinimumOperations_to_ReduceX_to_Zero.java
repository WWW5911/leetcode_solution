
class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int total = 0, ps = 0, leng = nums.length, ans = (int)1e9;
        for(int i = 0; i < leng; ++i)
            total += nums[i];
        if(total == x) return leng;
        hm.put(0,0);
        for(int i = 0; i < leng; ++i){
            ps += nums[i];
            if(hm.get(x+ps-total) != null ) {
                int tmp = leng-(i-hm.get(x+ps-total)+1);
                ans = ans > tmp ? tmp : ans;
            }
            hm.put(ps, i+1);
        }
        return ans == (int)1e9 ? -1 : ans;
    }
}

/*
70%抄
滑動窗格 這個問題可以變成 找出一個subarray 讓total - subarray的和等於x
一開始的窗格是0 接著慢慢往右擴 直到total - subarray > x
接著從0開始往左縮 直到== 或 < 
小於的情況就往右擴
*/

/*
prefix sum + hashmap
只看了標題
prefix sum 慢慢往右算 同時存到hashmap
如果total - ps < x 計算兩者差值 如果hm存在這個值 代表找到解
做到底找最小
*/