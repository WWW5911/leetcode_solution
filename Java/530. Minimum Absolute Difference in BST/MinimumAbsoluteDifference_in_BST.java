class Solution {
    int min = (int)1e9;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return min;
    }
    void find(TreeNode node){
        if(node == null) return;
        find(node.left);
        if(pre >= 0 && node.val - pre < min) min = node.val - pre;
        pre = node.val;
        find(node.right);
    }
}