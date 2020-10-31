public class Codec {
    String dig = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcd";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String tmp = ser_dfs(root);
        return tmp;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = new TreeNode(), pre = root, head = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(data.charAt(0) == 'n') return null;
        int i = 0, level = 0;
        root.val = To10(""+data.charAt(i)+data.charAt(i+1)) ;
        stack.add(root);
        while(!stack.empty() && root != null && i < data.length()){
            while(data.charAt(i) != 'n'){
                root.val = To10(""+data.charAt(i)+data.charAt(i+1)) ;
                stack.push(root);
                i+=2;
                if(data.charAt(i) != 'n') {
                    root.left = new TreeNode();
                    root = root.left;
                }
            }
            root = stack.pop();
            if(i+2 < data.length() &&data.charAt(i+2) != 'n'){
                root.right = new TreeNode( To10(""+data.charAt(i+2)+data.charAt(i+3) ) );
                root = root.right;
            }
            i+=2;
        }
        return head;
    }
    String ser_dfs(TreeNode root){
        if(root == null) return "nu";
        return To32(root) + /*"," +*/ ser_dfs(root.left) + /*"," +*/ ser_dfs(root.right);
    }
    String To32(TreeNode node){
        return dig.charAt((node.val+1000)/45) +""+ dig.charAt((node.val+1000)%45);
    }
    int To10(String str){
        return (str.charAt(0) > 58 ? str.charAt(0)-55 : str.charAt(0)-48)*45 + (str.charAt(1) > 58 ? str.charAt(1)-55 : str.charAt(1)-48)-1000;
    }
}