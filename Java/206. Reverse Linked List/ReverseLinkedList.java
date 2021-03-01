class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        do{
            stack.push(cur);
        }while( (cur = cur.next).next != null);
        head = cur;
        while(!stack.empty()){
            cur = stack.pop();
            cur.next.next = cur;
        }
        cur.next = null;
        return head;
    }
}