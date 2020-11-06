class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> al = new ArrayList<Integer>();
        for(int i = 0, index = -1, tmp = 0; i < nums.length; ++i){
            if(nums[i] == 0 || nums[i] == i+1) continue;
            tmp = nums[i];
            nums[i] = 0;
            while(tmp != 0){
                index = tmp;
                tmp = nums[index-1];
                nums[index-1] = index;
                if(index == tmp) {
                    al.add(index); 
                    break;
                }
            }
        }
        return al;
    }
}