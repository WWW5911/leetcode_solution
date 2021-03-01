class Solution {
    public String countAndSay(int n) {
        String str = n != 1 ? countAndSay(n-1) : "1", ans = "";
        if(n == 1) return str;
        for(int i = 1, count = 1; i <= str.length() ; ++i){
            if(i == str.length() || str.charAt(i) != str.charAt(i-1)){
                ans += (count +"") + str.charAt(i-1);
                count = 1;
            }else ++count;
        }
        return ans;
    }
}