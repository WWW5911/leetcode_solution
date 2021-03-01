class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        do{
            stack.push(cur);
        }while( (cur = cur.next) != null);
        
        while(!stack.empty()){
            cur = stack.pop();
            if(--n == 0) {
                if(cur.next != null){
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                }else {
                    cur = stack.pop();
                    cur.next = null;
                }
                break;
            }
        }
        return head;
    }
}