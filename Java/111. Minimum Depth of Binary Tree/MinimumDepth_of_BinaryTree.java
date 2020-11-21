class Solution {
    public int minDepth(TreeNode root) {
        if(root == null ) return 0;
        if(root.left == null && root.right == null) return 1;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        if(l == 0 || r == 0) return l == 0 ? r+1 : l+1;
        return l < r ? l+1 : r+1 ; 
    }
}