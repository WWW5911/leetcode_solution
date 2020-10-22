class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0), cur = new ListNode(0, ans);
        while(l1 != null || l2 != null){
            if(cur.next == null) cur.next = new ListNode(0);
            cur = cur.next;
            if(l1 != null) cur.val += l1.val;
            if(l2 != null) cur.val += l2.val;
            if(cur.val > 9) {
                cur.val-=10;
                cur.next = new ListNode(1);
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        } 
        return ans;
    }
}