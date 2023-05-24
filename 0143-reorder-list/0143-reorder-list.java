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
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        
        ListNode fh = head;
        ListNode sh = reverse(findMidNode(head));
        
        while (fh != null && sh != null) {
            ListNode temp = fh.next;
            fh.next = sh;
            fh = temp;
            
            temp = sh.next;
            sh.next = fh;
            sh = temp;
        }
        
        if (fh != null)
            fh.next = null;   
    }
    
    private ListNode findMidNode(ListNode head) {
        ListNode fastPointer = head, slowPointer = head;
        
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        
        return slowPointer;
    }
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null, cur = node, next = node.next;
        
        while (cur != null) {
            cur.next = prev;

            prev = cur;
            cur = next;
            
            if (next != null)
                next = cur.next;
        } 
        
        return prev;       
    }
}