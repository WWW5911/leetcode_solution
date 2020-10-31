class Solution {
    public Node connect(Node root) {
        if(root == null || root.left == null) return root;
        root.left.next = root.right;
        root.right.next = root.next != null ?root.next.left : null;
        connect(root.left);
        connect(root.right);
        return root;
    }
}
/*
每一個點要做的事都相同
將左小孩連向右小孩
將右小孩連向自己的next的左小孩
從左邊開始做才能確保每個點都連到
*/