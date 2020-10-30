class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n == m) return head;
        ListNode from = head, cur = head, next = head, pre, pref = head;
        n -= m;
        while(--m > 0) {
            pref = from;
            from = from.next;
        }
        pre = from;
        next = from.next;
        while(n-- > 0){
            cur = next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        from.next = next;
        if(from != pref) pref.next = cur;
        else return cur;
        return head;
    }
}