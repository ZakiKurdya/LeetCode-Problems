/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        
        while (cur != null && cur.next != null) {
            // swap
            int temp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = temp;
                    
            // go to next pair
            cur = cur.next.next;
        }
        
        return head;
    }
}