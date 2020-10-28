class Solution {
    boolean flag = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root != null) dfs(root, sum, 0);
        return flag;
    }
    void dfs(TreeNode root,int sum, int now){
        now += root.val;
        if(flag) return;
        if(root.left == root.right && sum == now) flag = true;
        if(root.left != null) dfs(root.left, sum, now);
        if(root.right != null) dfs(root.right, sum, now);
    }
}