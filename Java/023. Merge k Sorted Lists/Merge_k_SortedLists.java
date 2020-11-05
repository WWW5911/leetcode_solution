class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0; i < lists.length; ++i){
            ListNode cur = lists[i];
            while(cur != null){
                pq.add(cur.val);
                cur = cur.next;
            }
        }
        ListNode head = pq.peek() == null ? null : new ListNode(pq.poll()), cur = head;
        while(pq.peek() != null){
            cur.next = new ListNode(pq.poll());
            cur = cur.next;
        }
        return head;
    }
}