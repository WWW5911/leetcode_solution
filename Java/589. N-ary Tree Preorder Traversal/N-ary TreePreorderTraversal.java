class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> al = new ArrayList<Integer>();
        dfs(root, al);
        return al;
    }
    void dfs(Node root, List<Integer> al){
        if(root == null) return;
        al.add(root.val);
        for(int i = 0; i < root.children.size(); ++i){
            dfs(root.children.get(i), al);
        }
        return;
    }
}