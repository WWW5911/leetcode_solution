class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int lindex = 0, rindex = arr.length-1, leng = arr.length; 
        while(lindex < leng-1 && arr[lindex] <= arr[lindex+1]) ++lindex;
        if(lindex == leng-1) return 0;
        while(rindex > lindex && arr[rindex-1] <= arr[rindex]) --rindex;
        int ans = leng - lindex -1 > rindex ? rindex : leng - lindex -1, i = 0, j = rindex;
        while(i <= lindex && j <= leng-1){
            if(arr[i] <= arr[j]){
                ans = ans > j-i-1 ? j-i-1 : ans;
                ++i;
            }else{
                ++j;
            }
        }
        return ans;
    }
}
/*
半抄半想
首先移動左索引 找到從0開始最長的遞增子序列
接著移動右索引 找到從底開始的最長遞減子序列
然後答案先設為 底~左索引 跟右索引 之中最小的
接著在i = 0 ~ 左索引 j = 右索引~底
如果 arr[i] 小於等於arr[j] 代表他目前這組能做 更新一次解答 之前與現在最小的
同時++i
如果大於 代表arr[j]不夠大 所以讓j++
如此找到最小子序列
*/