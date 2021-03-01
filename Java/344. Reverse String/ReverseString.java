class Solution {
    public void reverseString(char[] s) {
        int f = 0, l = s.length-1;
        while(f < l){
            char c = s[f];
            s[f++] = s[l];
            s[l--] = c;
        }
    }
}