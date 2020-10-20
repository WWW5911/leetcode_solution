class Solution {
    public Node cloneGraph(Node node) {
        ArrayList<Node> queue = new ArrayList<Node>();
        HashMap<Node, Node> mapping = new HashMap<Node, Node>();
        if(node != null)
            mapping.put(node, new Node(node.val));
        else return node;
        queue.add(node);
        int index = 0;
        while(queue.size()!= 0){
            Node cur = queue.get(0), cloned = mapping.get(cur);
            queue.remove(0);
            for(Node i : cur.neighbors){
                Node temp = mapping.get(i);
                if(temp == null){
                    temp = new Node(i.val);
                    queue.add(i);
                    mapping.put(i, temp);
                }
                cloned.neighbors.add(temp);
            }
            mapping.put(cur, cloned);
        }
        return mapping.get(node);
    }
}