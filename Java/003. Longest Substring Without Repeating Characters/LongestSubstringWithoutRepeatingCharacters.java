class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<Character>();
        int length = 0, ans = 0;
        for(int i = 0; i+ans < s.length(); ++i){
            if( length > 0 &&s.charAt(i-1 >-1 ? i-1 : 0) != s.charAt(i+length-1) ){
                hs.remove( s.charAt(i-1 >-1 ? i-1 : 0) );
                --length;
            }
            while(i+length < s.length() && !hs.contains(s.charAt(i+length)) ){
                hs.add(s.charAt(i+length));
                length++;
            }
            ans = ans > length ? ans : length;
        }
        return ans;
    }
}