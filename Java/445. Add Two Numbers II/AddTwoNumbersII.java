class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1, tmp2 = l2;
        Stack<ListNode> stack1 = new Stack<ListNode>(), stack2 = new Stack<ListNode>(); 
        while(tmp1 != null || tmp2 != null){
            if(tmp1 != null) {
                stack1.push(tmp1);
                tmp1 = tmp1.next;
            }
            if(tmp2 != null) {
                stack2.push(tmp2);
                tmp2 = tmp2.next;
            }
        }
        ListNode ans = new ListNode(0), tmp3 = ans;
        while(!stack1.empty() || !stack2.empty()){
            if(!stack1.empty()) tmp3.val += stack1.pop().val;
            if(!stack2.empty()) tmp3.val += stack2.pop().val;
            if(tmp3.val > 9){
                tmp3.val -= 10;
                tmp3.next = new ListNode(1);
            }else tmp3.next = new ListNode(0);
            tmp3 = tmp3.next;
        }
        if(ans != null && ans.next != null){
            tmp1 = ans.next;
            tmp2 = ans;
            tmp3 = null;
        }
        while(tmp1 != null){
            tmp2.next = tmp3;
            tmp3 = tmp2;
            tmp2 = tmp1;
            tmp1 = tmp1.next;
        }
        tmp2.next = tmp3;
        return tmp2.val == 0 ? tmp2.next : tmp2;
    }
}