class Solution {
    boolean flag = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(!flag) return false;
        if(p == q) return true;
        else if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        if(p.left != null && q.left != null) flag = isSameTree(p.left, q.left);
        else if(p.left != q.left) return false;//if one of them != null
        if(p.right != null && q.right != null) flag = isSameTree(p.right, q.right);
        else if(p.right != q.right) return false;//if one of them != null
        return flag;
    }
}