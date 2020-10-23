class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null) return ans;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(!stack.empty() || cur != null){ //有可能走到右最底+1
            while(cur != null ){ //如果自己不是null 就把自己扔進去 然後往左走 如此來走到左邊的底 同時存下中間經過的
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();//由於上述會做到最左的下一個左節點(null) 所以要把最後存的拉出來
            ans.add(cur.val);//中序 放進ans
            cur = cur.right; //直接讓cur 等於右節點 如果右邊沒東西 自然不會過中間的while 接著就會取出上個節點 如果右邊有東西 就往右走 不丟進stack的原因是會重覆紀錄目前節點
        }
        return ans;
    }
}