/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head, fastPointer = head;
        
        while (fastPointer != null) {
            slowPointer = slowPointer.next;
            
            if (fastPointer.next == null)
                return false;
    
            fastPointer = fastPointer.next.next;
            
            if (slowPointer == fastPointer)
                return true;
        }
        
        return false;
    }
}