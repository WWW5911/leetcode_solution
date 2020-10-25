import java.util.StringTokenizer;
class Solution {
    public String simplifyPath(String path) {
        StringTokenizer st = new StringTokenizer(path, "/");
        Stack<String> stack = new Stack<String>(), stack2 = new Stack<String>() ;
        String ans = "";
        while(st.hasMoreTokens()){
            String now = st.nextToken();
            if(now.charAt(0) == '.' && now.length() == 2){
                if(!stack.empty()) stack.pop();
            }else if(now.charAt(0) != '.' || now.length() >= 3) stack.push(now);
        }
        while(!stack.empty())
            stack2.push(stack.pop());
        while(!stack2.empty())
            ans += "/"+stack2.pop();
        if(ans.length() == 0) ans += "/";
        return ans;
    }
}