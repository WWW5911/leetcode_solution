public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head, temp = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                while(slow != temp){
                    temp = temp.next;
                    slow = slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}