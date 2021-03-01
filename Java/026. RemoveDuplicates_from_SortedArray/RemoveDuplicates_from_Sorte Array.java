class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        int cont = 0;
        for(int n : nums)
            if(hs.add(n))
                nums[cont++] = n;
        return hs.size();
    }
}