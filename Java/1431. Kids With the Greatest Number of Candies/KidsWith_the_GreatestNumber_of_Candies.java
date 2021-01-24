class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0, leng = candies.length;
        for(int i = 0; i < leng; ++i)
            max = max > candies[i] ? max : candies[i];
        List<Boolean> ans = new ArrayList<Boolean>();
        for(int i = 0; i < leng; ++i)
            ans.add(candies[i]+extraCandies >= max ? true : false);
        return ans;
    }
}