class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> li = new ArrayList<String>();
        String str = "";
        boolean flag = false;
        for(int i = 0; i < nums.length ; ++i){
            if(i+1 < nums.length && nums[i+1] - nums[i] == 1){
                if(!flag) str += (nums[i] + "");
                flag = true;
            }else{
                if(flag) str += "->"; 
                flag = false;
                str += nums[i]+"";
                li.add(str);
                str = "";
            }
        }
        return li;
    }
}