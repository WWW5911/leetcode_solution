class Solution {
    public int[] plusOne(int[] digits) {
        int p = 1;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i = digits.length-1; i >= 0; --i){
            int tmp = digits[i] + p ;
            al.add(0, tmp >= 10 ? tmp - 10 : tmp);
            p = tmp >= 10 ? 1 : 0;
        }
        if(p == 1) al.add(0,1);
        return al.stream().mapToInt(i -> i).toArray(); 

    }
}