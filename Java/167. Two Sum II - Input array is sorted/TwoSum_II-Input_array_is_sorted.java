class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int [] ans = {1, 0}; ans[0] <= numbers.length; ++ans[0])
            for(ans[1] = ans[0]+1; ans[1] <= numbers.length; ++ans[1])
                if(numbers[ans[0]-1] + numbers[ans[1]-1] == target) return ans;
        return null;
    }
}