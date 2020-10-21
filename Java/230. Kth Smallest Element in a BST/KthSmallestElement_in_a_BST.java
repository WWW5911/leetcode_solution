/* Brute Force
class Solution {
    ArrayList<Integer> al = new ArrayList<Integer>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);
        Collections.sort(al);
        return al.get(k-1);
    }
    void dfs(TreeNode root){
        al.add(root.val);
        if(root.left != null ) dfs(root.left);
        if(root.right != null ) dfs(root.right);
    }
}
*/
/* dfs to travel
class Solution {
    int cur = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return ans;
    }
    void dfs(TreeNode root, int k){
        if(ans != 0) return;
        if(root.left != null ) dfs(root.left, k);
        if(++cur == k) ans = root.val;
        if(root.right != null ) dfs(root.right, k);
    }
}*/
//Divide and Conquer
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);
        if(count >= k){ //if left count >= k, it means kth in left tree 
            return kthSmallest(root.left, k);
        }
        else if(count + 1 < k){ //if count+1 = k, root is answer. And k need to substarct count(left) and root
            return kthSmallest(root.right, k-count-1);
        }
        return root.val; //root is answer
    }
    int count(TreeNode node){
        if(node == null) return 0;
        return 1 + count(node.left) + count(node.right); 
    }
}

